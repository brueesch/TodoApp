'use strict';

function addEntry() {

    var description = document.getElementById("description").value;
    var priority = document.getElementById("priority").value;


    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if(this.readyState === 4 && this.status === 200) {
            alert(this.responseText);
        }
    };
    xhttp.open("POST", "http://localhost:8080/api/addEntry", true);
    // xhttp.open("POST", "http://todo-app-todoapp.193b.starter-ca-central-1.openshiftapps.com/api/addEntry", true);
    xhttp.setRequestHeader("Content-type", "application/json");
    xhttp.send("{\"priority\":\"" + priority + "\",\"description\":\""+description+"\"}");

}

function getAllEntries() {

    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if(this.readyState === 4 && this.status === 200) {
            document.getElementById("entries").innerText = this.responseText;
        }
    };
    xhttp.open("GET", "http://localhost:8080/api/getAllEntries", true);
    xhttp.setRequestHeader("Content-type", "application/json");
    xhttp.send();

}

function getAllEntriesForToday() {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if(this.readyState === 4 && this.status === 200) {
            document.getElementById("entries").innerText = this.responseText;
        }
    };
    xhttp.open("GET", "http://localhost:8080/api/getAllEntriesForToday", true);
    xhttp.setRequestHeader("Content-type", "application/json");
    xhttp.send();
}