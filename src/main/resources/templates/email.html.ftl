<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>重要通知</title>
    <style>
        body {
background-color: #f4f4f4;
margin: 0;
padding: 0;
}

.container {
max-width: 600px;
margin: 30px auto;
background-color: #fff;
padding: 20px;
border-radius: 5px;
box-shadow: 0 0 5px rgba(0, 0, 0, 0.1);
}

h1 {
color: #333;
}

.btn {
display: inline-block;
background-color: #007BFF;
color: #fff;
padding: 10px 20px;
text-decoration: none;
border-radius: 3px;
margin-top: 20px;
}

.btn:hover {
background-color: #0056b3;
}

.row {
margin: 20px 0;
}
</style>
</head>

<body>
<div class="container">
    <h3>通知标题：${title}</h3>

    <div class="row">
        <span>待审批数据: </span>
        <span>${data}</span>
    </div>

    <div class="row">
        <span>提交时间: </span>
        <span>${submitTime}</span>
    </div>

    <div class="row">
        <span>审批截止时间: </span>
        <span>${endTime}</span>
    </div>

    <div class="row">
        <span>审批链接如下: </span>
        <a href="${url}">${url}</a>
    </div>

    <a href="${url}" class="btn">点击跳转到审批页</a>
</div>
</body>

</html>