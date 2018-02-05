var playerA=0;
var playerB=0;
var gamingPeople=0;
var people=0;
var centre={
    update:{
        updatePeople:function () {
            return $("#onlineCentreNumber").val(sessionStorage.getItem("PEOPLE"));
        },
        feedBack:function () {
            DwrPush.refresh();
        },
        setPeople:function (people) {
            sessionStorage.setItem("PEOPLE",people);
        },
    },
    game:{
        /*setGamingPeople:function (number) {
            $("#textAreaInput").html($("#textAreaInput").html()+msg);
            gamingPeople=number;
        },
        setPlayerA:function (number) {
            $("#textAreaInput").html($("#textAreaInput").html()+msg);
            playerA=number;
        },
        setPlayerB:function (number) {
            $("#textAreaInput").html($("#textAreaInput").html()+msg);
            playerB=number;
        }*/
    }
}