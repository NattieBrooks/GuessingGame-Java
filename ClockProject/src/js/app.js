//create date object
var $today = new Date();

// Extract Time variable from date object
var $hours = $today.getHours();
var $minutes = $today.getMinutes();
var $seconds = $today.getSeconds();
var $time = $hours + " : " + $minutes + " : " + $seconds;

//Extract Date varialbe to date object
var $day = $today.getDay() + 1;
var $month = $today.getMonth() + 1;
var $year = $today.getFullYear();
var $date = $month + " / " + $day + " / " + $year;


//Access date elements in html 

// var todayHours = document.getElementById("hours");
// var todayMinutes = document.getElementById("minutes");
// var todaySeconds = document.getElementById("seconds");

// var todayDay = document.getElementById("day");
// var todayMonth = document.getElementById("month");
// var todayYear = document.getElementById("year");

function showTime(){
    var writeTime = document.getElementById("time").innerText= $time;
    //var writeDate = document.getElementById("date").innerText = $date;
}

showTime();
setInterval(showTime, 1000);






