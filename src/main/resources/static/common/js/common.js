/*****************************************
 ************** 화면 설정 ***************
 *****************************************/





/*****************************************
 ************** 테이블 관련 처리 ***********
 *****************************************/

// 테이블 목록에 게시물이 없는 경우 NO_DATA 표시
function noData(){
    $('.table tbody').not(':has(tr)').append('<tr><td class="text-center" colSpan="'+$('.table thead th').length+'">NO_DATA</td></tr>');
}



/*****************************************
 ************** 페이지 이동 ****************
 *****************************************/

// playground 홈으로 이동
function goPlaygroundHome(){
    location.href='/home';
}

// horror 홈으로 이동
function goHorrorHome(){
    location.href='/horror';
}


// 무서운이야기 게시판으로 이동
function goHorrorStory(){
    location.href='/horror/story';
}



/*****************************************
 *************** ajax *******************
 *****************************************/


<!-- ajax -->
function ajax(_url, _param, _after)
{
    console.log(_url);

    $.ajax({
        url: _url,
        type: 'POST',
        data: _param,
        dataType: 'JSON',
        error: function(request, status, error){
            console.log('error!!!');
            console.log('Code:'+request.status+' / Message:'+request.responseText+' / Error: '+error);
        },
        success: function(data){
            console.log('success!!!');
            if(typeof _after != undefined && "" != _after) {
                new Function(_after)();
            }
        }
     });
}