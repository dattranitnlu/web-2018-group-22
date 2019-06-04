<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<div class="home" style="background: #0D2C62">

	<div class="container">
		<div class="row">
			<div class="col text-center">
				<div class="home_slider_title">The Premium System Education</div>
				<div class="home_slider_subtitle">Future Of Education
					Technology</div>
				<div class="home_slider_form_container">
					<form method="post" action="SearchController"
						class="home_search_form d-flex flex-lg-row flex-column align-items-center justify-content-between">
						<div
							class="d-flex flex-row align-items-center justify-content-start">
							<input name="search" type="search" class="home_search_input"
								placeholder="Keyword Search" required="required">
							 <select name="type" class="dropdown_item_select home_search_input">
								<option value="grammar">Grammar</option>
								<option value="vocabulary">Vocabulary</option>
							</select>
						</div>
						<button type="submit" class="home_search_button">search</button>
					</form>
				</div>
			</div>
		</div>
	</div>



</div>