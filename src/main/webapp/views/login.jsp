<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ include file="/common/taglib.jsp" %>

        <div class="container-fluid tm-mt-60">
            <div class="row tm-mb-50">
                <div class="col-lg-12 col-12 mb-5">
                    <h2 class="tm-text-secondary mb-5 text-center">Login</h2>
                    <form id="login-form" action="login-request" method="POST"
                        class="tm-contact-form mx-auto was-validated">
                        <div class="form-group">
                            <input type="text" name="username" class="form-control rounded-0" placeholder="Userame"
                                required />
                        </div>
                        <div class="form-group">
                            <input type="password" name="password" class="form-control rounded-0" placeholder="Password"
                                required />
                        </div>
                        <div class="form-group tm-text-right">
                            <button name="dologin" type="submit" class="btn btn-secondary">Send</button>
                        </div>
                    </form>
                </div>
                <p style="color: red;">${message }</p>
            </div>
        </div>