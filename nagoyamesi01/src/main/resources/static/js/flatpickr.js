let maxDate = new Date();
maxDate = maxDate.setMonth(maxDate.getMonth() + 3);

flatpickr('#reservationDate', {
	 locale: "ja",
    altInput: true,
    minDate: 'today',
    dateFormat: "Y-m-d"
});


flatpickr('#reservationTime', {
	enableTime: true,
	noCalendar: true,
	dateFormat: "H:i",
	time_24hr: true
})