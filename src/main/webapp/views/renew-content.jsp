<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class=" box-2 d-flex flex-column h-100">
    <form action="controller" method="post">
        <p class="lblTitle" style>First Time Login</p>

        <p class="question">Câu hỏi 1:</p>
        <select name="question1" class="questionSelect">
            <option value="partner">Vợ/chồng bạn tên là gì?</option>
            <option value="pet">Thú nuôi của bạn tên gì?</option>
            <option value="parent">Mẹ/bố bạn tên là gì?</option>
            <option value="child">Con trai/con gái bạn tên là gì?</option>
        </select> <br>
        <label class="answer">
            <input type="text" class="inputUaP" name="answer1" placeholder="...">
        </label>

        <p class="question">Câu hỏi 2:</p>
        <select name="question1" class="questionSelect">
            <option value="partner">Vợ/chồng bạn tên là gì?</option>
            <option value="pet">Thú nuôi của bạn tên gì?</option>
            <option value="parent">Mẹ/bố bạn tên là gì?</option>
            <option value="child">Con trai/con gái bạn tên là gì?</option>
        </select> <br>
        <label class="answer">
            <input type="text" class="inputUaP" name="answer2" placeholder="...">
        </label>

        <p class="question">Câu hỏi 3:</p>
        <select name="question1" class="questionSelect">
            <option value="partner">Vợ/chồng bạn tên là gì?</option>
            <option value="pet">Thú nuôi của bạn tên gì?</option>
            <option value="parent">Mẹ/bố bạn tên là gì?</option>
            <option value="child">Con trai/con gái bạn tên là gì?</option>
        </select> <br>
        <label class="answer">
            <input type="text" class="inputUaP" name="answer3" placeholder="...">
        </label>

        <p>Old password:</p>
        <label>
            <input type="text" class="inputUaP" name="oldPassword" placeholder="...">
        </label>

        <p>New Password:</p>
        <label>
            <input type="password" class="inputUaP" name="newPassword" placeholder="...">
        </label>

        <p class="lblUaP">Confirm New Password:</p>
        <label class="lblUaP">
            <input type="password"class="inputUaP" name="newPassword" placeholder="...">
        </label>

        <button class="btnlogin" type="submit" name="action" value="login">Reset</button>

        <button class="btnlogin" type="submit" name="action" value="login">Log in</button>

        <p id="noti">${result}</p>
    </form>
</div>