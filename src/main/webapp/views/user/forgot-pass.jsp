	<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
	<div class="container-fluid tm-mt-60 d-flex justify-content-center">
        <div class="row tm-mb-50 w-25">
            <div class="col-lg-12 col-12 mb-5">
                <h2 class="tm-text-danger mb-5">Forgot Password</h2>
                <form action="/forgotPass" method="post" class="was-validated">
	                <div class="form-group mx-auto">
	                    <input type="email" name="email" id="email" class="form-control rounded-0" placeholder="Email" required />
	                </div>
	                <div class="form-group tm-text-right">
	                    <button type="submit" id="sendBtn" class="btn btn-danger">Send</button>
	                </div>
                </form>
                <h5 class="text-success">${forgot_pass }</h5>
                <h5 class="text-warning">${forgot_pass_wrong }</h5>
            </div>
    	</div>
    </div>
