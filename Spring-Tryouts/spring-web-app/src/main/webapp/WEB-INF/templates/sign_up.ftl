<#assign sf=JspTaglibs["http://www.springframework.org/tags/form"]>
<html>
<head>
    <title>Sign up</title>
</head>
<body>
<form action="/users/new" method="post">
    <input name="name" type="text" placeholder="name">
    <input name="surname" type="text" placeholder="surname">
    <input name="email" type="text" placeholder="email">
    <input type="submit">
</form>
</body>
</html>