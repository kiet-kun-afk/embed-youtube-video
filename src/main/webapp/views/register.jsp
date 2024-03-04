<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>

	<div class="container-fluid tm-mt-60">
        <div class="row tm-mb-50">
            <div class="col-lg-12 col-12 mb-5">
                <h2 class="text-primary mb-5 text-center">Register</h2>
                <form id="register-form" action="handle-register" method="POST" class="tm-contact-form mx-auto was-validated">
                    <div class="form-group">
                        <input type="text" name="username" class="form-control rounded-0" placeholder="Userame" pattern=".{3,}" required />
                        <div class="invalid-feedback">Please fill out this field, three characters or more.</div>
                    </div>
                    <div class="form-group">
                        <input type="password" name="password" class="form-control rounded-0" placeholder="Password" pattern=".{8,}" required />
                        <div class="invalid-feedback">Please fill out this field, eight characters or more.</div>
                    </div>
                    <div class="form-group">
                        <input type="password" name="cfmpass" class="form-control rounded-0" placeholder="Confirm Password" pattern=".{8,}" required />
                        <div class="invalid-feedback">Please fill out this field, eight characters or more.</div>
                    </div>
                    <div class="form-group">
                        <input type="email" name="email" class="form-control rounded-0" placeholder="Email" required />
                        <div class="invalid-feedback">Please provide a valid email.</div>
                    </div>
                    <div class="form-group">
						<div>
							<img src="data:realCaptcha/jpg;base64,${realCaptcha}" />
						</div>
					</div>
					<div class="form-group">
						<input type="hidden" name="hiddenCaptcha" value="${hiddenCaptcha}" />
						<input type="text" name="captcha" id="captcha" class="form-control rounded-0" value="${captcha}" placeholder="Captcha" pattern=".{5,}" required/>
						<div class="invalid-feedback">Please fill out this field, five characters.</div>
					</div>
                    <div class="form-group tm-text-right">
                        <button type="submit" class="btn btn-success">Send</button>
                    </div>
                </form>
            </div><p style="color: red;">${message }</p>
    	</div>
    </div>