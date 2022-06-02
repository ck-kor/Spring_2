let targetId;

// $(document).ready(function () {
//     getMessages();
// })
//
// // 게시글을 불러옵니다.
// function getMessages() {
//     $('#cards-box').empty();
//     $.ajax({
//         type: "GET",
//         url: "/api/contents",
//         data: {},
//         success: function (response) {
//             for (let i = 0; i < response.length; i++) {
//                 let post = response[i];
//                 let id = post.id;
//                 let name = post.name;
//                 let title = post.title;
//                 let contents = post.contents;
//                 let modifiedAt = post.modifiedAt;
//                 addHTML(id, name, title, contents, modifiedAt);
//             }
//         }
//     });
// }
//
// function addHTML(id, name, title, contents, modifiedAt) {
//     let tempHtml = makeMessage(id, name, title, contents, modifiedAt);
//     $('#cards-box').append(tempHtml);
// }
//
// function makeMessage(id, name, title, contents, modifiedAt) {
//     return `<a href="detail.html?id=${id}">
//                         <div class="card">
//                             <div class="metadata">
//                                <div ${id}="${id}-name" class="name">
//                                    ${name}
//                                </div>
//                                <div class="date">
//                                    ${modifiedAt}
//                                </div>
//                             </div>
//                         <h2 class='title' id="${id}-title">"${title}"</h2>
//                             <div class="contents" id="${id}-contents" >
//                                ${contents}
//                             </div>
//                             </a>
//                         </div>`;
// }



// function logingo() {
//
//     $.ajax({
//         type: "GET",
//         url: "/login",
//         data: {},
//         success:function (response){
//             alert("로그인 페이지로 이동합니다.")
//             location.href = '/login'
//         },
//         error: function (xhr, ajaxOptions, thrownError) {
//             alert(xhr.status);
//             alert(thrownError);
//         }
//
//     })
// }

// function addProduct(itemDto) {
//     $.ajax({
//         type: "POST",
//         url: '/api/products',
//         contentType: "application/json",
//         data: JSON.stringify(itemDto),
//         success: function (response) {
//             $('#container').addClass('active');
//             targetId = response.id;
//         }
//     })
// }
//
// function setMyprice() {
//     let myprice = $('#myprice').val();
//     if (myprice == '') {
//         alert('올바른 가격을 입력해주세요');
//         return;
//     }
//     $.ajax({
//         type: "PUT",
//         url: `/api/products/${targetId}`,
//         contentType: "application/json",
//         data: JSON.stringify({myprice: myprice}),
//         success: function (response) {
//             $('#container').removeClass('active');
//             alert('성공적으로 등록되었습니다.');
//             window.location.reload();
//         }
//     })
// }