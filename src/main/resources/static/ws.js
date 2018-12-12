var hostname = location.hostname;
var port = location.port;
var url = 'ws://'+hostname+':'+port+'/web/wsm';
var ws = new WebSocket(url);
ws.onopen = function(e)
{
    ws.send('hello');
   /* setInterval(function(){
        ws.send('ping')
    },1000)*/
};

ws.onmessage = function(e) {
    console.log(e)
    var obj = jQuery.parseJSON(e.data);
    if (obj.code == "2000") {
        console.log("必须超过出发");
    }

};

ws.onerror = function(e) {
    console.log(e)
};

// 断开 web socket 连接成功触发事件
/*ws.onclose = function () {
    alert("连接已关闭...");
};*/
