

/*****************************************
 ************** 테이블 ****************
 *****************************************/

// 테이블 목록에 게시물이 없는 경우 NO_DATA 표시
function noData(){
    $(".table tbody").not(":has(tr)").append("<tr><td>NO_DATA</td></tr>");
}





/*****************************************
 ************** 페이지 이동 ****************
 *****************************************/

// playground 홈으로 이동
function goPlaygroundHome(){
    location.href="/home";
}

// horror 홈으로 이동
function goHorrorHome(){
    location.href="/horror";
}


// horror 홈으로 이동
function goHorrorStory(){
    location.href="/horror/story";
}

