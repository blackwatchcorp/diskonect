<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Diskonect</title>
    <link rel="icon" href="/diskonect/favicon.ico" type="image/x-icon">
    <script src="https://unpkg.com/htmx.org@2.0.2"></script>
</head>
<body>
    <h1>Diskonect</h1>
    <div id="create-post-container">
        <#include "create-post-btn.ftl">
    </div>
    <#list posts as post>
        <#include "post.ftl">
    <#else>
        <p>No posts yet!</p>
    </#list>
</body>
</html>
