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
