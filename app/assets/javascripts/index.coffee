$ ->
  $.get "/applicants", (data) ->
    $.each data, (index, applicant) ->
      $('#applicants').append $("<li>").text (""+applicant.name+", "+applicant.dateInterview+"")
