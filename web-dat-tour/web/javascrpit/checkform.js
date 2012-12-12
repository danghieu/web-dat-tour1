function check_form()
{
//Khai báo các biến để lấy giá trị từ người dùng khi họ nhập dữ liệu vào form.
user=form.username.value
email=form.email.value
matkhau=form.password.value
nlmatkhau=form.retypepassword.value

//Khai báo các biến để thông báo lỗi khi có lỗi xảy ra ^^!
var loiht=document.all("iduser");
var loimail=document.all("idemail");
var loimatkhau=document.all("idmk");
var loinlmatkhau=document.all("idnlmk");
//Check ô họ và tên 
if(hoten=="") //Nếu họ tên bỏ trống không nhập gì hết
{
form.username.style.backgroundColor='red'; //Đổi màu nền ô textbox
loiht.innerHTML="Username không được rỗng !"; //Xuất ra dòng thông báo lỗi nếu họ tên bỏ trống.
form.username.focus(); //Đặt lại tiêu điểm (Tức là con trot chuột ấy) vào ô bị lỗi
return; //Quay lại check tiếp khi nhận đc tiêu điểm .
}
loiht.innerHTML="";	 //Xóa dòng thông báo lỗi khi nhập đúng.	

//check mail cũng tuwowg tự y hệt như trên
dangmail= /^[\w.-]+@[\w.-]+\.[A-Za-z]{2,4}$/ //Tạo biểu thức quy tắc (tức là định dạng 1 mail nó như thế nào).
kq=dangmail.test(email);	 //Kiểm tra mail mà người dùng nhập vào.
if(email=="") //Nếu mail bỏ trống 
{
form.email.style.backgroundColor='red';
loimail.innerHTML="Email không được bỏ trống";
form.email.focus();
return;

}
loimail.innerHTML="";
if(kq==false)
{
form.email.style.backgroundColor='red';
loimail.innerHTML="Sai định dạng email !";
form.email.focus();
return;
}
loimail.innerHTML="";
if(matkhau=="")
{
form.password.style.backgroundColor='red';
loimatkhau.innerHTML="Mật khẩu không được để trống !";
form.password.focus();
return;
}
loimatkhau.innerHTML="";
if(nlmatkhau=="")
{
form.nlmatkhau.style.backgroundColor='red ';
loinlmatkhau.innerHTML="Xác nhận mật khẩu !";
form.nlmatkhau.focus();
return;
}
loinlmatkhau.innerHTML="";


if(matkhau!=nlmatkhau)
{
form.retypepassword.style.backgroundColor='red' ;
loinlmatkhau.innerHTML="Noi dung khong duoc bo trong !";
form.retypepassword.focus();
return;
}
loinlmatkhau.innerHTML="";
form.submit();

}