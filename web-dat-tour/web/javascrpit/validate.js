/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function() {
  $("#login-form").validate({
        rules: {
          username: "required",// simple rule, converted to {required:true}
          
        password: {
          required: true
        }
        },
        messages: {
          username: "Please enter username.",
          password: "Please enter passowrd."
        }
      });
 });

