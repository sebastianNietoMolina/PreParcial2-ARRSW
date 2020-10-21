appiclient = (function (){

    function getCountries(callback){
            $.get("http://localhost:8080/stats", function(data){
                    callback(data);
                }, 'json');

    }

    function getDataByCountry(name, callback){

        $.get("http://localhost:8080/stats/"+name, function(data){
                        callback(data);
                    }, 'json');

    }

    return {
            getCountries: getCountries,
            getDataByCountry: getDataByCountry
        };

})();



