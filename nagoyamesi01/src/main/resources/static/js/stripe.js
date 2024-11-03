const stripe = Stripe('pk_test_51Pt3FIIN3pSzdAqcESdnv92FNRdmtdk3SHQUK9FoPmmoPDXpGn7GPZNSSV1cphijxgmvbkoGJrYzWVxD32a88qe800FBk0pU9S');
 const paymentButton = document.querySelector('#paymentButton');
 
 paymentButton.addEventListener('click', () => {
   stripe.redirectToCheckout({
     sessionId: sessionId
   })
 });