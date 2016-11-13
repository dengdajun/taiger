
//地图
function load() {


//        var x=document.getElementById("demo");
    function getLocation(){
        if (navigator.geolocation){
            navigator.geolocation.getCurrentPosition(showPosition);
        }else{
            alert("Geolocation is not supported by this browser.");
        }


    }
//        function showPosition(position){
//            if(map){
//                map.setCenter(position);
//            }else{
//                alert("地图微赚被好好");
//            }
////            x.innerHTML="Latitude: " + position.coords.latitude + "<br />Longitude: " + position.coords.longitude;
//        }



    var map = new BMap.Map("container");
    var point = new BMap.Point(118.9048680000,32.1177050000); //默认中心点      "lng":118.92138303355874,"lat":32.10031609048804}     118.9048680000,32.1177050000
//        var point = new BMap.Point(b,a);
//            position.coords.latitude      position.coords.longitude
//            var point = new BMap.Point(a,b);
    var marker = new BMap.Marker(point);
    var opts = {
        width: 250,     // 信息窗口宽度
        height: 100     // 信息窗口高度
        //title: "信息窗口标题"  // 信息窗口标题
    }

    marker.enableDragging(); //启用拖拽
    marker.addEventListener("dragend", function (e) {
        point = new BMap.Point(e.point.lng, e.point.lat); //标记坐标（拖拽以后的坐标）
        marker = new BMap.Marker(point);

        document.getElementByIdx_x("lng").value = e.point.lng;
        document.getElementByIdx_x("lat").value = e.point.lat;
        infoWindow = new BMap.InfoWindow("当前位置<br />经度：" + e.point.lng + "<br />纬度：" + e.point.lat, opts);

        map.openInfoWindow(infoWindow, point);
    })

    map.addControl(new BMap.NavigationControl()); //左上角控件
    map.enableScrollWheelZoom(); //滚动放大
    map.enableKeyboard(); //键盘放大

    map.centerAndZoom(point, 13); //绘制地图
    map.addOverlay(marker); //标记地图


    // 打开信息窗口
//        map.openInfoWindow(map.getCenter());
}



