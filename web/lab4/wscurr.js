var webSocket;
var oldVal;

function openSocket() {

    var cur1 = document.getElementsByTagName("input")[0];
    var cur2 = document.getElementsByTagName("input")[1];
    //var currencyInfo = "price:"+cur1.value+":"+cur2.value;
    var currencyInfo = {
        crypto: cur1.value,
        currency: cur2.value
    };
    if (webSocket !== undefined && webSocket.readyState !== WebSocket.CLOSED) {
        webSocket.close();
    }

    if (!cur2.value.length || !cur1.value.length) {
        alert("Введите значения обеих валют!")
    }

    webSocket = new WebSocket("ws://localhost:8080/stock");

    webSocket.onopen = function (event) {
        oldVal = 0;
        console.log('Websocket connection open');
        webSocket.send(JSON.stringify(currencyInfo))
    };

    webSocket.onmessage = function (event) {
        //var currenciesInfo = jQuery.parseJSON(event.data);
        var currenciesInfo = JSON.parse(event.data);


        //forming new rows
        var connectWait = document.getElementById("waiting");
        connectWait.style.display = "none";

        var tempTable = document.getElementById("trade_table_body");

        var newRow = document.createElement("tr");
        newRow.setAttribute("class", cur1.value);
        newRow.setAttribute("class", currenciesInfo.name);

        //forming cells
        var cryptoCurNameCell = document.createElement("th");
        cryptoCurNameCell.innerHTML = cur1.value;

        var currencyNameCell = document.createElement("th");
        currencyNameCell.innerHTML = currenciesInfo.name;

        var valueOfCryptCell = document.createElement("th");
        valueOfCryptCell.innerHTML = currenciesInfo.price;

        var statusImgCell = document.createElement("th");
        var imgSrc = document.createElement("img");
        if (currenciesInfo.price > oldVal && oldVal !== 0) {
            imgSrc.setAttribute("src", "images/up.png")
            imgSrc.setAttribute("height","30");
            imgSrc.setAttribute("width","30");
        }
        if (currenciesInfo.price < oldVal && oldVal !== 0) {
            imgSrc.setAttribute("src", "images/down.png");
            imgSrc.setAttribute("height","30");
            imgSrc.setAttribute("width","30");
        }
        statusImgCell.appendChild(imgSrc);

        newRow.appendChild(cryptoCurNameCell);
        newRow.appendChild(currencyNameCell);
        newRow.appendChild(valueOfCryptCell);
        newRow.appendChild(statusImgCell);

        if (currenciesInfo.price !== oldVal || oldVal === 0) {
            tempTable.prepend(newRow);
        }


        oldVal = currenciesInfo.price;
        webSocket.send(JSON.stringify(currencyInfo))
    };
}