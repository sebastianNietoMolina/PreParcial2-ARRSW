
apimock = (function () {

    var seats = [[false, false, false, true, false, true, true, true, true, true, true, true], [true, true, true, true, true, true, true, true, false, false, true, true], [true, true, true, true, true, false, true, true, true, true, true, true], [true, true, true, true, false, true, true, true, false, true, true, true], [true, true, true, true, true, true, false, true, false, true, true, true], [true, true, true, true, true, false, false, false, true, true, true, true], [true, true, true, true, true, true, false, false, true, true, true, true]];
    var mockdata = [];
    var function1Y = {"movie": {"name": "SuperHeroes Movie", "genre": "Action"}, "seats": seats, "date": "2018-12-19 17:00"};
    var function2Y = {"movie": {"name": "The Night", "genre": "Horror"}, "seats": seats, "date": "2018-12-19 19:40"};
    var function3Y = {"movie": {"name": "SuperHeroes Movie", "genre": "Action"}, "seats": seats, "date": "2018-12-19 14:30"};
    var function4Y = {"movie": {"name": "The Enigma", "genre": "Drama"}, "seats": seats, "date": "2018-12-20 17:00"};

    mockdata["cinemaX"] = {"name": "cinemaX", "functions": [{"movie": {"name": "The Enigma", "genre": "Drama"}, "seats": seats, "date": "2018-12-18 15:30"}, {"movie": {"name": "The Enigma 2", "genre": "Drama"}, "seats": seats, "date": "2018-12-18 15:30"}]};
    mockdata["cinemaY"] = {"name": "cinemaY", "functions": [function1Y, function2Y, function3Y, function4Y]};

    return {
        getFunctionsByCinema: function (cinema_name, callback) {
            callback(mockdata[cinema_name]);
        },
        getFunctionsByCinemaAndDate: function (cinema_name, fdate, callback) {
            callback(
                    mockdata[cinema_name].functions.filter(
                    funct => funct.date.includes(fdate))
            );
        }

    }

})();







/*
 Example of use:
 var fun=function(list){
 console.log("listo"");
 }
 apimock.getFunctionsByCinema("cinemaX",fun);
 apimock.getFunctionsByCinemaAndDate("cinemaX","2018-12-18",fun);*/
