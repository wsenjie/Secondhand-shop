var map;
var markerLayer;
function initMap(lat,lng,filter) {
    //定义地图默认中心点坐标
    var center=new TMap.LatLng(lat,lng);
    //创建map对象，初始化地图
    if (map){
        map.setCenter(center);
        return;
    }
    map = new TMap.Map('map', {
        center: center,//设置地图中心点坐标
        zoom: 16,   //设置地图缩放级别
    });
    console.log(lat+","+lng);
    //创建并初始化MultiMarker
    markerLayer = new TMap.MultiMarker({
        map: map,  //指定地图容器
        //样式定义
        styles: {
            //创建一个styleId为"myStyle"的样式（styles的子属性名即为styleId）
            "myStyle": new TMap.MarkerStyle({
                "width": 25,  // 点标记样式宽度（像素）
                "height": 35, // 点标记样式高度（像素）
                "src": '/img/marker.png', //图片路径
                //焦点在图片中的像素位置，一般大头针类似形式的图片以针尖位置做为焦点，圆形点以圆心位置为焦点
                "anchor": { x: 16, y: 32 },
            })
        },
        //点标记数据数组
        geometries: [{
            "id": "1",   //点标记唯一标识，后续如果有删除、修改位置等操作，都需要此id
            "styleId": 'myStyle',  //指定样式id
            "position": new TMap.LatLng(lat,lng),  //点标记坐标位置
            "properties": {//自定义属性
                "title": "marker1"
            }
        }
        ]
    });
    //定义事件处理方法
    var clickHandler=function(evt){
        var lat = evt.latLng.getLat().toFixed(6);
        var lng = evt.latLng.getLng().toFixed(6);
        form.val(filter,{
            lat: lat,
            lng: lng
        });
        markerLayer.updateGeometries([{
            "id": "1",   //点标记唯一标识，后续如果有删除、修改位置等操作，都需要此id
            "styleId": 'myStyle',  //指定样式id
            "position": new TMap.LatLng(lat, lng),  //点标记坐标位置
            "properties": {//自定义属性
                "title": "marker"
            }
        }
        ])
    };
    //Map实例创建后，通过on方法绑定点击事件
    map.on("click",clickHandler);
}
