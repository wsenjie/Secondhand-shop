// layui初始化(必须)
layui.use('element', function () {
    var element = layui.element;
});

// 获取数据
function getData(url, data) {
    var temp;
    $.ajax({
        type: 'get',
        url: url,
        data: data ? data : {},
        async: false,
        success: function (data) {
            if (data) {
                // console.log(data);
                temp = data;
            } else {
                temp = null;
            }
        }
    });
    return temp;
}

// 实例化表格封装  ok
function tableInstance(table, url, cols) {
    cols.unshift({type: 'checkbox', fixed: 'left'});
    cols.push({fixed: 'right', title: '操作', width: 165, align: 'center', toolbar: '#bar'});
    // 表格实例化    queryData.url
    return table.render({
        elem: '#table'
        , loading: true
        , height: 390
        , toolbar: 'default'
        , url: url
        , page: true //开启分页
        , cols: [cols]
    });
}

//监听工具栏事件  ok
function listenTool(table, form, queryUrl, updateUrl, updateDelUrl, insertUrl,clearDelUrl) {
    //监听头工具栏事件
    table.on('toolbar(table)', function (obj) {
        var checkStatus = table.checkStatus(obj.config.id)
            , data = checkStatus.data; //获取选中的数据
        switch (obj.event) {
            case 'add':
                if (!insertUrl)
                    layer.msg('此功能暂未开发');
                else location.href = insertUrl;
                break;
            case 'update':
                if (data.length === 0) {
                    layer.msg('请选择一行');
                } else if (data.length > 1) {
                    layer.msg('只能同时编辑一个');
                } else {
                    // layer.alert('编辑 [id]：' + checkStatus.data[0].id);
                    var updateIndex = openDiv(form, queryUrl, checkStatus.data[0].id, ['1000px']);
                    updateSubmit(form, updateIndex, updateUrl);
                }
                break;
            case 'delete':
                if (data.length === 0) {
                    layer.msg('请选择一行');
                } else {
                    var idList = [];
                    for (var i = 0; i < data.length; i++) {
                        idList.push(data[i].id);
                    }
                    updateDel(updateDelUrl, idList, 1);
                }
                break;
            case 'recover':
                if (clearDelUrl == null){
                    layer.msg('此功能暂未开发');
                    break;
                }
                if (data.length === 0) {
                    layer.msg('请选择一行');
                } else {
                    var idList = [];
                    for (var i = 0; i < data.length; i++) {
                        idList.push(data[i].id);
                    }
                    updateDel(updateDelUrl, idList, 0);
                }
                break;
        }
    });
    //监听行工具事件
    table.on('tool(table)', function (obj) { //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"
        var data = obj.data //获得当前行数据
            , layEvent = obj.event; //获得 lay-event 对应的值
        switch (layEvent) {
            case 'del':
                //向服务端发送删除指令
                updateDel(updateDelUrl, [data.id], 1);
                break;
            case 'edit':
                // layer.msg('编辑操作');
                var updateIndex = openDiv(form, queryUrl, data.id, ['1000px']);
                updateSubmit(form, updateIndex, updateUrl);
                break;
            case 'recover':
                updateDel(updateDelUrl,[data.id], 0);
                break;
            default:
                layer.msg('此功能暂未开发');
        }
    });
    // 绑定清空回收站事件
    $(".clearDel").click(function () {
        clearDel(clearDelUrl);
    });
}

// 监听查询表单提交     ok
function querySubmit(form, tableIns) {
    form.on('submit(querySubmit)', function (data) {
        // layer.msg(JSON.stringify(data.field));
        var field = data.field;
        tableIns.reload({
            where: field,
            page: {
                curr: 1
            }
        });
        return false;
    });
}

// 更新提交 ok
function updateSubmit(form, updateIndex, url) {
    if (url == null) {
        return;
    }
    form.on('submit(updateSubmit)', function (data) {
        // layer.msg(JSON.stringify(data.field));
        data.field.id = $('#update').attr('data-id');
        $.ajax({
            type: 'post',
            url: url,
            data: data.field,
            success: function (data) {
                if (data) {
                    layer.close(updateIndex);
                    $('#query').click();
                    layer.msg('操作成功');
                } else {
                    layer.msg('操作失败,' + data.msg);
                }
            }
        });
        return false;
    });
}

// 删除和恢复   ok
function updateDel(url, idList, del) {
    layer.confirm('是否确认？', function (index) {
        $.ajax({
            type: 'get',
            url: url,
            data: {
                idList: idList,
                del: del
            },
            success: function (data) {
                if (data) {
                    $('#query').click();
                    layer.msg('操作成功');
                }
            }
        });
    })
}

// 弹出框封装    ok
function openDiv(form, queryUrl, id) {
    var data = getData(queryUrl, {id: id});
    console.log(data);
    var updateForm = $('#update');
    $('.list').empty();
    updateForm.attr('data-id', id);
    if (data) {
        var allowParams = ['head', 'img', 'identity'];
        for (var index in allowParams) {
            var param = allowParams[index];
            if (param in data) {
                eval("$('#img').attr('src',data." + param + ")");
                break;
            }
        }
    }
    var updateIndex = layer.open({
        title: '修改',
        type: 1,
        area: ['1000px', '500px'],
        shade: 0,
        resize: false,
        maxWidth: 800,
        content: updateForm
    });
    updateForm[0].reset();
    form.val("updateForm", data);
    return updateIndex;
}

// 清空回收站
function clearDel(url) {
    layer.confirm('确认清空回收站？', function (index) {
        $.ajax({
            type: 'get',
            url: url,
            data: {},
            success: function (data) {
                if (data) {
                    $('#query').click();
                    layer.msg('操作成功');
                }
            }
        });
    })
}