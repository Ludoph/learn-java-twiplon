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

// Sélectionnez tous les boutons "btn-commentaire"
const btnsComment = document.querySelectorAll(".btn-commentaire");

// Parcourez tous les boutons et ajoutez des gestionnaires d'événements
btnsComment.forEach((btnComment) => {
  const textComment =
    btnComment.parentElement.parentElement.querySelector(".commentaire");
  const btnCommenter =
    btnComment.parentElement.parentElement.querySelector(".commenter");
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

    const postId = btnCommenter.dataset.idcomment;
    const commentText = textComment.value;

    fetch("/commentaire", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({
        commentId: postId,
        textcomment: commentText,
      }),
    }).then((response) => response.json());
  });
});

function deletePost(iconElement) {
  var postId = iconElement.getAttribute("data-post-id");
  var postDate = iconElement.parentElement
    .querySelector(".post-date")
    .getAttribute("data-post-date");
  var postContent = iconElement.parentElement
    .querySelector(".post-content")
    .getAttribute("data-post-content");
  var likesCount = iconElement.parentElement
    .querySelector(".count-like")
    .getAttribute("data-likes-count");

  if (
    confirm(
      "Voulez-vous vraiment supprimer ce post?\nDate : " +
        postDate +
        "\nContenu : " +
        postContent +
        "\nLikes : " +
        likesCount
    )
  ) {
    // Utiliser AJAX pour supprimer le post
    $.ajax({
      url: "/deletePost/" + postId, // Remplacez par l'URL correcte de votre endpoint de suppression
      type: "DELETE",
      success: function (response) {
        // Mettre à jour l'interface utilisateur après la suppression réussie
        // Par exemple, supprimer le post du DOM ou rafraîchir la liste des posts
      },
      error: function (error) {
        // Gérer les erreurs en cas d'échec de la suppression
      },
    });
  }
}
