<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Error page</title>
    <meta name="theme-color" content="#101119">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
    <link rel="stylesheet" href="/templates/error-page/style.css">
</head>

<body>
    <!-- partial:index.partial.html -->
    <section class="error-body">
        <video preload="auto" class="background" src="https://s3-us-west-2.amazonaws.com/s.cdpn.io/396624/err.mp4"
            autoplay muted loop></video>
        <div class="message">
            <div class="bottom">
                <p>Something went wrong</p>
                <a href="/index">return home</a>
            </div>
        </div>
    </section>
    <!-- partial -->
    <script src="/templates/error-page/script.js"></script>

</body>

</html>