const urlLogin = "http://localhost:8080/user/login";
const urlLogout = "http://localhost:8080/user/logout";
const urlSignup = "http://localhost:8080/user/signup";

let userId = "";
let password = "";
let userName = "";
let userEmail = "";
let newuserId = "";
let newpassword = "";

document.querySelector("#userId").addEventListener("change", (e) => {
  console.log(e.target.value);
  userId = e.target.value;
});
document.querySelector("#password").addEventListener("change", (e) => {
  console.log(e.target.value);
  password = e.target.value;
});

document.querySelector("#newuserId").addEventListener("change", (e) => {
  console.log(e.target.value);
  newuserId = e.target.value;
});
document.querySelector("#newpassword").addEventListener("change", (e) => {
  console.log(e.target.value);
  newpassword = e.target.value;
});

document.querySelector("#userName").addEventListener("change", (e) => {
  console.log(e.target.value);
  userName = e.target.value;
});
document.querySelector("#userEmail").addEventListener("change", (e) => {
  console.log(e.target.value);
  userEmail = e.target.value;
});

document.querySelector(".loginBtn").addEventListener("click", () => {
  const data = {
    userId: userId,
    password: password,
  };
  axios
    .post(urlLogin, data, { withCredentials: true })
    .then((response) => {
      console.log("데이터: ", response);
      sessionCurrent();
    })
    .catch((error) => {
      console.log("에러 발생: ", error);
    });
});
document.querySelector(".logoutBtn").addEventListener("click", () => {
  if (confirm("로그아웃하시겠습니까?")) {
    axios.post(urlLogout, {}, { withCredentials: true }).then((response) => {
      console.log("데이터 : ", response);
      if (response.status == 200) {
        document.querySelector(".login-box").classList.remove("hidden");
        document.querySelector(".user-box").classList.add("hidden");
      }
    });
  }
});

document.querySelector(".signupBtn").addEventListener("click", () => {
  document.querySelector(".signup-box").classList.remove("hidden");
  document.querySelector(".login-box").classList.add("hidden");
});

document.querySelector(".signupBtnInput").addEventListener("click", () => {
  if (confirm("회원가입하시겠습니까?")) {
    const data = {
      userId: newuserId,
      password: newpassword,
      userName: userName,
      userEmail: userEmail,
    };
    axios
      .post(urlSignup, data, { withCredentials: true })
      .then((response) => {
        console.log("데이터: ", response);
        alert("회원가입이 완료되었습니다. 로그인해주세요.");
        window.location.reload();
      })
      .catch((error) => {
        console.log("에러 발생: ", error);
      });
  }
});

function sessionCurrent() {
  axios
    .get("http://localhost:8080/user/current", { withCredentials: true })
    .then((response) => {
      console.log("데이터 : ", response);
      if (response.status == 200) {
        console.log("세션유지");
        if (response.status == 200) {
          document.querySelector(".login-box").classList.add("hidden");
          document.querySelector(".user-box").classList.remove("hidden");
          document.querySelector(".user-box p").textContent =
            response.data.userId + "님, 환영합니다.";
        }
      }
    })
    .catch((error) => {
      console.log("에러발생 : ", error);
    });
}

//js 파일이 로드 될때 호출됨
sessionCurrent();
