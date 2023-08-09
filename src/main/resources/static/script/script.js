// Like b
document.querySelectorAll(".btn-like").forEach((btnLike) => {
  btnLike.addEventListener("click", function () {
    console.log(btnLike.dataset.idpost);
    fetch("/like", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({ postId: btnLike.dataset.idpost }),
    })
      .then((response) => response.json())
      .then((data) => {
        let likeCountElement = btnLike.querySelector(".count-like");
        if ((likeCountElement.textContent = data.likeCount));
      });
  });
});

document.querySelectorAll(".fa-heart").forEach((heartChange) => {
  heartChange.addEventListener("click", function () {
    heartChange.classList.remove("fa-regular");
    heartChange.classList.add("fa-solid");
  });
});

// Comment button
const btnComment = document.querySelector(".btn-commentaire");
let textComment = document.querySelector(".commentaire");
const btnCommenter = document.querySelector(".commenter");
let isCommentVisible = false;
btnComment.addEventListener("click", function () {
  console.log(btnComment);
  if (isCommentVisible) {
    textComment.style.display = "none";
    btnCommenter.style.display = "none";
  } else {
    textComment.style.display = "flex";
    btnCommenter.style.display = "flex";
  }
  isCommentVisible = !isCommentVisible;
});

btnCommenter.addEventListener("click", function () {
  console.log(btnCommenter);
  btnCommenter.style.display = "none";
  textComment.style.display = "none";
  console.log(btnCommenter.dataset.idpost);
  textComment = document.querySelector(".commentaire");
  console.log(textComment.value);
  fetch("/commentaire", {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify({
      commentId: btnCommenter.dataset.idcomment,
      textcomment: textComment.value,
    }),
  }).then((response) => response.json());
});
