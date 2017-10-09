function validateEmptyField(field) {
   
    if (field.value.length == 0) {
    	field.style.background = 'Red'; 
       alert("The required field can't be left blank");
       field.focus();
        return false;  
    }else {
    	field.style.background = 'White';
    }
    return true;  
}

function validateCharacters(field, fieldName)
{
	var letters = /^[A-Za-z]+$/;  
	if(!field.value.match(letters))  
	{   
		alert(fieldName + " must have alphabet characters only");
		field.style.background = 'Red';
		field.focus();  
		return false;  
	}  
	return true;
}

function validateLength(field, minValue, maxValue, fieldName)
{  
	if(fieldName=="Mobile Number")
	{
		if((field.value.length < 10) || (field.value.length > 10))
		{
			alert("Mobile Number must be of 10 Integers");
			field.focus();
			return false;
		}
	}
	else
	{
		if ((field.value.length < minValue))  
		{   
			alert(fieldName + " must be greater than " + minValue + " characters");
			field.style.background = 'Red';
			field.focus();  
			return false;  
		}  
		else if ((field.value.length > maxValue))  
		{   
			alert(fieldName + " must be smaller than " + maxValue + " characters");
			field.style.background = 'Red';
			field.focus();  
			return false;  
		}  
	}
	return true;
}

function validateAlphaNumericCharacters(field, fieldName)
{
	var letters = /^[0-9a-zA-Z ]+$/;  
	if(!field.value.match(letters))  
	{   
		alert(fieldName + " must have alphanumeric characters only");
		field.style.background = 'Red';
		field.focus();  
		return false;  
	}  
	return true;
}

function validateNumericCharacters(field, fieldName)
{
	var numbers = /^[0-9]+$/;    
	if(!field.value.match(numbers))  
	{   
		alert(fieldName + " must have numeric characters only");
		field.style.background = 'Red';
		field.focus();  
		return false;  
	}  
	return true;
}

function validateUserName()
{
	if(!validateEmptyField(user_form.userName))
		return false;
	
	if (!validateCharacters(user_form.userName, "User Name"))
		return false;
	
	return true;
}

function validatePassword()
{
	if(!validateEmptyField(user_form.password))
		return false;
	
	if (!validateLength(user_form.password,3,15, "Password"))
		return false;
	
	return true;
}

function validateAddress()
{
	if(!validateEmptyField(user_form.address))
		return false;
	
	if(!validateAlphaNumericCharacters(user_form.address,"Address"))
		return false;
	
	return true;
}

function validateContactNumber()
{
	if(!validateEmptyField(user_form.contactNumber))
		return false;
	
	if(!validateNumericCharacters(user_form.contactNumber,"Mobile Number"))
		return false;
	
	if (!validateLength(user_form.contactNumber,9,10, "Mobile Number"))
		return false;
	
	return true;
}

function validateCity()
{
	if(!validateEmptyField(user_form.city))
		return false;
	
	if(!validateCharacters(user_form.city,"City"))
		return false;
	
	return true;
}

function validateState()
{
	if(!validateEmptyField(user_form.state))
		return false;
	
	if(!validateCharacters(user_form.state,"State"))
		return false;
	
	return true;
}

function validateProductName()
{
	if(!validateEmptyField(product_form.productName))
		return false;
	
	if (!validateCharacters(product_form.productName, "Product Name"))
		return false;
	
	return true;
}

function validateProductCode()
{
	if(!validateEmptyField(product_form.productCode))
		return false;
	
	var letters = /^[a-zA-Z0-9-]+$/;  
	if(!product_form.productCode.value.match(letters))  
	{   
		alert("Product Code must have alphanumeric characters and hiphen only");
		product_form.productCode.style.background = 'Red';
		product_form.productCode.focus();  
		return false;  
	}  
	
	return true;
}

function validateProductDescription()
{
	if(!validateEmptyField(product_form.productDescription))
		return false;
	
	if (!validateAlphaNumericCharacters(product_form.productDescription, "Product Description"))
		return false;
	
	return true;
}

function validatePrice()
{
	if(!validateEmptyField(product_form.price))
		return false;
	
	 var regex = /^(\$|)([1-9]\d{0,2}(\,\d{3})*|([1-9]\d*))(\.\d+)?$/;
     var passed = product_form.price.value.match(regex);
     if (passed == null) {
         alert("Enter price only. For example: 523.36 or 523");
         product_form.price.style.background = 'Red';
         product_form.price.focus();  
         return false;
     }
	
	return true;
}

function validateStock()
{
	if(!validateEmptyField(product_form.stock))
		return false;
	
	if (!validateNumericCharacters(product_form.stock, "Stock"))
		return false;
	
	return true;
}

function validateUserForm()
{
	if(!validateUserName())
		return false;
	
//	if(!validatePassword())
//		return false;
	
	if(!validateContactNumber())
		return false;
	
	if(!validateAddress())
		return false;
	
	if(!validateCity())
		return false;
	
	if(!validateState())
		return false;

    return true;
}

function validateForm(formName)
{
	if(!validateEmptyField(formName.name))
		return false;
	
	return true;
}

function validateCategoryForm()
{
	if(!validateEmptyField(category_form.categoryName))
		return false;
	
	if(!validateCharacters(category_form.categoryName,"Category"))
		return false;
	
	return true;
}

function validateProductForm()
{
	if(!validateProductName())
		return false;
	
	if(!validateProductCode())
		return false;
	
	if(!validateProductDescription())
		return false;
	
	if(!validatePrice())
		return false;
	
	if(!validateStock())
		return false;
	
	return true;
}