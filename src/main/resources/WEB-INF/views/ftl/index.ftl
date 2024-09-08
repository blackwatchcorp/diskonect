<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Diskonect</title>
    <link rel="icon" href="/diskonect/favicon.ico" type="image/x-icon">
</head>
<body>
    <h1>Diskonect</h1>
    <#list posts as post>
        <#assign createdDateTime = post.createdAt()?datetime>
        <#assign createdAt = createdDateTime?string["yyyy-MM-dd HH:mm"]>
        <h3>${post.title()}</h3>
        <small>${createdAt}</small>
        <p>${post.content()}</p>
    <#else>
        <p>No posts yet!</p>
    </#list>
</body>
</html>
