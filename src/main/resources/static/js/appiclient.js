appiclient = (function (){

    function getCountries(callback){
            $.get("https://coronavirusars.herokuapp.com/stats", function(data){
                    callback(data);
                }, 'json');

    }

    function getDataByCountry(name, callback){

        $.get("https://coronavirusars.herokuapp.com/stats/"+name, function(data){
                        callback(data);
                    }, 'json');

    }

    return {
            getCountries: getCountries,
            getDataByCountry: getDataByCountry
        };

})();



