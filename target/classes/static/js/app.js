var app = (function () {

    var newData;
    var Country;

    function init(){
        appiclient.getCountries(_prettyPrint);

    }

    function _prettyPrint(data){
        newData = data;
        data.map(function (pais) {
            $("#tabla1 > tbody").append(
                "<tr> <td>" +
                "<form><button class='btn btn-primary' type='button' onclick='app.getDataByCountry(\"" +pais.country+ "\""+ ")' >"+
                 pais.country+"</button></form>"+
                "</td> <td>" + pais.deaths + "</td> <td>" + pais.confirmed+ "</td> <td>" + pais.recovered+"</td></tr>"
            );
        });

    }

    function getDataByCountry(name){
        Country = name;
        appiclient.getDataByCountry(name,_prettyPrint2)
    }

    function _prettyPrint2(data){
        $("#tabla3 > tbody").empty();
        data.map(function (pais) {
            $("#tabla3 > tbody").append(
                "<tr><td>"+pais.province+"</td><td>"+pais.deaths+"</td> <td>"+pais.confirmed+"</td><td>"+pais.recovered+"</td></tr>"
            );
        });

        for(var i=0; i<newData.length ; i++){
                if(newData[i].country=Country){
                    $("#tabla2 > tbody").empty();
                        $("#tabla2 > tbody").append(
                            "<tr><td> Num Deaths</td> <td>" + newData[i].deaths +
                            "</td></tr>" +"<tr> <td> Num Confirmed</td> <td>" + newData[i].confirmed +
                            "</td></tr>"+"<tr> <td> Num Recovered</td> <td>" + newData[i].recovered + "</td></tr>"
                        );
                }
        }
    }

    return {
        init: init,
        getDataByCountry: getDataByCountry
    };

})();