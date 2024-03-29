$(function () {
  $("#example1")
    .DataTable({
      responsive: true,
      lengthChange: false,
      autoWidth: false,
      buttons: ["copy", "csv", "excel", "pdf", "print", "colvis"],
    })
    .buttons()
    .container()
    .appendTo("#example1_wrapper .col-md-6:eq(0)");
  $("#example2").DataTable({
    paging: true,
    lengthChange: false,
    searching: false,
    ordering: true,
    info: true,
    autoWidth: false,
    responsive: true,
  });
});
var titleOrigin, hrefOrigin, descriptionOrigin, linkOrigin;
$(document).ready(function () {
  titleOrigin = $("#title").val();
  hrefOrigin = $("#href").val();
  descriptionOrigin = $("#description").val();
  linkOrigin = $("#youtube_link").val();
});
$("#resetBtn").click(function () {
  $("#title").val(titleOrigin);
  $("#href").val(hrefOrigin);
  $("#description").val(descriptionOrigin);
  $("#youtube_link").val(linkOrigin);
  if (hrefOrigin.length > 0) {
    $("#imgPreview").attr(
      "src",
      "https://img.youtube.com/vi/" + hrefOrigin + "/maxresdefault.jpg"
    );
  }
});

$("#href").change(function () {
  var newSrc = $("#href").val();
  $("#imgPreview").attr(
    "src",
    "https://img.youtube.com/vi/" + newSrc + "/maxresdefault.jpg"
  );
  $("#youtube_link").val("https://www.youtube.com/watch?v=" + newSrc);
});

$("#youtube_link").change(function () {
  var youtubeLinkValue = $(this).val();
  var match = youtubeLinkValue.match(/[?&]v=([^&#]*)/);
  var hrefValue = match ? match[1] : "";
  $("#href").val(hrefValue);
  var newSrc = $("#href").val();
  $("#imgPreview").attr(
    "src",
    "https://img.youtube.com/vi/" + newSrc + "/maxresdefault.jpg"
  );
});
function deleteVideo(href) {
  $.ajax({
    url: "/admin/video/delete?href=" + href,
    type: "DELETE",
  }).always(function () {
    window.location.href = "/admin/video";
  });
}
function recoverVideo(href) {
  $.ajax({
    url: "/admin/video/recover?href=" + href,
    type: "POST",
  }).always(function () {
    window.location.href = "/admin/video/inactiveVideos";
  });
}
function deleteUser(username) {
  $.ajax({
    url: "/admin/user/delete?username=" + username,
    type: "DELETE",
  }).always(function () {
    window.location.href = "/admin/activeUsers";
  });
}
function activeUser(username) {
  $.ajax({
    url: "/admin/user/activation?username=" + username,
    type: "GET",
  }).always(function () {
    window.location.href = "/admin/inactiveUsers";
  });
}
