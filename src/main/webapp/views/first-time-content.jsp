<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="box-2 d-flex flex-column h-100">
    <form action="updateProtection" method="post">
        <p class="title-label" style>First Time Login</p>

        <p class="question-header">Câu hỏi 1:</p>
        <label>
            <select name="question1" class="question-select-list">
                <option value="emty">--Vui lòng chọn câu hỏi dưới đây--</option>
                <option value="partner">Vợ/chồng bạn tên là gì?</option>
                <option value="pet">Thú nuôi của bạn tên gì?</option>
                <option value="parent">Mẹ/bố bạn tên là gì?</option>
                <option value="child">Con trai/con gái bạn tên là gì?</option>
            </select>
        </label> <br>
        <label class="answer">
            <input type="text" class="border-input" name="answer1" placeholder="...">
        </label>

        <p class="question-header">Câu hỏi 2:</p>
        <label>
            <select name="question2" class="question-select-list">
                <option value="emty">--Vui lòng chọn câu hỏi dưới đây--</option>
                <option value="partner">Vợ/chồng bạn tên là gì?</option>
                <option value="pet">Thú nuôi của bạn tên gì?</option>
                <option value="parent">Mẹ/bố bạn tên là gì?</option>
                <option value="child">Con trai/con gái bạn tên là gì?</option>
            </select>
        </label> <br>
        <label class="answer">
            <input type="text" class="border-input" name="answer2" placeholder="...">
        </label>

        <p class="question-header">Câu hỏi 3:</p>
        <label>
            <select name="question3" class="question-select-list">
                <option value="emty">--Vui lòng chọn câu hỏi dưới đây--</option>
                <option value="partner">Vợ/chồng bạn tên là gì?</option>
                <option value="pet">Thú nuôi của bạn tên gì?</option>
                <option value="parent">Mẹ/bố bạn tên là gì?</option>
                <option value="child">Con trai/con gái bạn tên là gì?</option>
            </select>
        </label> <br>
        <label class="answer">
            <input type="text" class="border-input" name="answer3" placeholder="...">
        </label>

        <p class="question-header">Old password:</p>
        <label>
            <input type="text" class="border-input" name="oldPassword" placeholder="...">
        </label>

        <p class="question-header">New Password:</p>
        <label>
            <input type="password" class="border-input" name="newPassword1" placeholder="...">
        </label>

        <p class="question-header">Confirm New Password:</p>
        <label>
            <input type="password"class="border-input" name="newPassword2" placeholder="...">
        </label> <br>

        <p class="error-alert">${result}</p>

        <div class="center-div">
            <button class="border-button">Reset</button>
            <button class="border-button" type="submit">Log in</button>
        </div>


    </form>
</div>