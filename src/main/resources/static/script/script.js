const btnLike = document.getElementById("btn-like");
btnLike.addEventListener("click", function () {
  console.log(btnLike.dataset.idpost);
  fetch("/like", {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify({ postId: btnLike.dataset.idpost }),
  }).then((response) => response.json());
});

const heartChange = document.querySelector(".fa-heart");
heartChange.addEventListener("click", function () {
  heartChange.classList.remove("fa-regular");
  heartChange.classList.add("fa-solid");
});
