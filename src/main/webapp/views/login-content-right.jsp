<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class=" box-2 d-flex flex-column h-100">
    <form action="controller" method="post">
        <p class="lblTitle">Log in</p>

        <label hidden="hidden">
            <input type="text" class="checkbox" name="action" value="login">
        </label>

        <p class="lblUaP">Username:</p>
        <label class="lblUaP">
            <input type="text" id="username" class="inputUaP" name="userid" placeholder="...">
        </label>

        <p class="lblUaP">Password:</p>
        <label class="lblUaP">
            <input type="password" id="password" class="inputUaP" name="password" placeholder="...">
        </label>

        <label>
            <input type="checkbox" class="checkbox" name="checkbox" value="remember">
        </label>
        <label>Remember me</label><br>

        <button class="btnlogin" type="submit" name="action" value="login">Log in</button>

        <p id="noti">${result}</p>
    </form>
</div>