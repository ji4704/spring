//package dw.gameshop;
//
//public class memo {
//
//<index.js>
//
//            /* (public static main() { */
//            const url = "http://localhost:8080/products";
////then()함수
////promise 연결 함수 // then은 앞쪽에 있는 promise 코드가 끝나면 실행된다. (앞에 할 일을 적는다.)
////사용예 : axios.get(url).then(할일 = 익명함수).then(할일).then(할일).catcjh(에러처리); -> 이러한 문법을 자바에서 promise then 이라고 부른다.
//axios
//        .get(url)
//            .then((response) => {
//        console.log("응답 Response : ", response);
//        displayProduct(response.data);
//    })
//            .catch((error) => {
//        console.log("에러발생 : ", error);
//    });
//
//    function displayProduct(gameData) {
//        console.log(gameData.length);
//        if (gameData.length > 0) {
//    const content = document.querySelector(".content");
//            gameData.forEach((data) => {
//      const game = document.createElement("div");
//            game.classList.add("game");
//      const img = document.createElement("img");
//            img.classList.add("image");
//            img.src = data.image;
//            game.appendChild(img);
//      const title = document.createElement("p");
//      const genre = document.createElement("p");
//      const price = document.createElement("p");
//            title.textContent = "게임 타이틀 : " + data.title;
//            genre.textContent = "게임 장르 : " + data.genre;
//            price.textContent = "게임 가격 : " + data.price + "원";
//            game.appendChild(title);
//            game.appendChild(genre);
//            game.appendChild(price);
//            content.appendChild(game);
//    });
//        }
//    }
//
//
//
//<css>
//    @font-face {
//        font-family: "GmarketSansMedium";
//        src: url("https://fastly.jsdelivr.net/gh/projectnoonnu/noonfonts_2001@1.1/GmarketSansMedium.woff")
//        format("woff");
//        font-weight: normal;
//        font-style: normal;
//    }
//* {
//        margin: 0;
//        padding: 0;
//        box-sizing: border-box;
//        font-family: s GmarketSansMedium;
//    }
//.container {
//  /* PC는 좌우 여백이 없으면 어색하기 때문에
//    보통 70 ~ 80% 를 사용하고 나머지를 여백으로 준다.
//    모바일 웹페이지는 80~90%를 사용 */
//        width: 70%;
//  /* 세로는 제한이 없으므로 height 사용X
//  개발환경을 보여주기 위해 사용 */
//  /* footer까지 설정 후 사용했던
//  height: 100vh; 삭제 */
//
//        margin: 0 auto;
//        border: 1px solid black;
//    }
//.title {
//        width: 100%;
//        height: 150px;
//        background-color: lightblue;
//        /* font-size: 32px; */
//        /* 가운데 정렬 25 ~ 27번 줄 */
//        display: flex;
//        justify-content: center;
//        align-items: center;
//        font-size: 2rem;
//        color: dodgerblue;
//    }
//.menu {
//        width: 100%;
//        /* height: 50px; */
//        background-color: dodgerblue;
//        display: flex;
//        justify-content: start;
//        align-items: center;
//    }
//.content {
//        width: 100%;
//        display: grid;
//        background-color: khaki;
//        grid-template-columns: 1fr 1fr 1fr;
//        gap: 20px;
//        padding: 20px;
//    }
//.footer {
//        width: 100%;
//        height: 100px;
//        background-color: lightblue;
//        padding: 20px;
//    }
//.menu > div {
//        width: 120px;
//        height: 50px;
//        text-align: center;
//        line-height: 45px;
//        color: white;
//        font-weight: 700;
//        font-size: 1.3rem;
//    }
//.menu > div:hover {
//        color: dodgerblue;
//        background-color: white;
//        cursor: pointer;
//    }
//.game {
//        border-radius: 5px;
//        background-color: white;
//        box-shadow: 2px 2px 5px 1px rgba(0, 0, 0, 2);
//        padding-bottom: 20px;
//    }
//.game:hover {
//        box-shadow: 2px 2px 5px 5px rgba(0, 0, 0, 0.4);
//        transform: translate(0px, -5px);
//        cursor: pointer;
//    }
//.image {
//        width: 100%;
//    }
//.content p {
//        margin: 0 0 5px 10px;
//    }
//.login {
//        height: 300px;
//        background-color: khaki;
//        display: flex;
//        align-items: center;
//    }
//.login-box {
//        width: 450px;
//        display: grid;
//        grid-template-columns: 40% 100%;
//        grid-template-rows: 1fr 1fr 1fr;
//        justify-content: center;
//        align-items: center;
//        gap: 20px;
//        margin-left: 30px;
//        padding: 30px;
//        background-color: white;
//        box-shadow: 2px 2px 5px 1px rgba(0, 0, 0, 0.2);
//        font-size: 1.3rem;
//        border-radius: 5px;
//    }
//.login_btn {
//        width: 100px;
//        height: 40px;
//        background-color: dodgerblue;
//        color: white;
//        font-weight: 700;
//        text-align: center;
//        line-height: 35px;
//        border-radius: 5px;
//        cursor: pointer;
//    }
//.login_btn:hover {
//        background-color: lightblue;
//        color: dodgerblue;
//    }
//
//
//<>
//}
