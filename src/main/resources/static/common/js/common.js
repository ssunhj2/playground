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

// welcome 페이지로 이동
function goWelcome(){
    location.href='/';
}

// 로그인 페이지로 이동
function goLogin(){
    location.href='/login';
}

// 로그아웃
function goLogout(){
    location.href='/logout';
}

// playground 홈으로 이동
function goPlaygroundHome(){
    location.href='/home';
}

// 회원정보 페이지로 이동
function goAccount(){
    location.href='/account';
}

// horror 홈으로 이동
function goHorrorHome(){
    location.href='/horror';
}


// 무서운이야기 게시판으로 이동
function goHorrorStory(){
    location.href='/horror/story';
}

// 파일 다운로드
function download(fileNo){
    console.log(fileNo)

    location.href='/download?fileNo=' + fileNo;
}


/*****************************************
 *************** ajax *******************
 *****************************************/


<!-- ajax -->
function ajaxJson(_url, _param, _after)
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
            if(typeof _after != undefined && "" != _after) {
                return _after('fail');
            }
        },
        success: function(data){
            console.log('success!!!');
            if(typeof _after != undefined && "" != _after) {
                return _after(data);
            }
        }
     });
}


/*****************************************
 *************** 값 체크 *******************
 *****************************************/

function chkEmptyText(_element, _msg){
    if(typeof _element == 'undefined' || _element == '') return false;

    if(_element.val() == ""){
        alert(_msg + ' 을(를) 입력해주세요.');
        return false;
    }

    return true;
}



function isEmptyObject(_obj){
    if(_obj.constructor === Object && Object.keys(_obj).length === 0) return true;

    return false;
}