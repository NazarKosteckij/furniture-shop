function removeProduct(event){
    console.log(event.id);
    showModal("Підтвердіть вашу дію", "Ви справді хочете видалити цей товар?", function(){
        var rowRecord = event.parentNode.parentNode;

        sendRemoveProduct(event.id, function(){ $(rowRecord).remove();});
    });
}

function removeCategory(event){
    console.log(event.id);
    showModal("Підтвердіть вашу дію", "Ви справді хочете видалити цю категорію?", function(){
        var rowRecord = event.parentNode.parentNode;

        sendRemoveCategory(event.id, function(){$(rowRecord).remove();});
    });
}

/**
 *
 * @param tittle {@link string}
 * @param content {@link string}
 * @param confirmFunction {@link function}
 */
function showModal(tittle, content, confirmFunction){
    const  MODAL_ID = "#confirmation-dialog";
    const  MODAL_HEADER_ID = "#modal-tittle";
    const  MODAL_CONTENT_ID = "#modal-content";
    const  MODAL_CONFIRM_ID = "#modal-confirm-action";

    var modal = $(MODAL_ID);
    $(MODAL_HEADER_ID).html(tittle);
    $(MODAL_CONTENT_ID).html(content);
    $(MODAL_CONFIRM_ID).unbind();
    $(MODAL_CONFIRM_ID).click(confirmFunction);

    modal.openModal({dismissible: true});
}

function sendRemoveProduct(id, successFunction){
    $.ajax({
        url: './' + id,
        type: 'DELETE',
        success: function(result) {
            Materialize.toast("Видалено", 3000);
            successFunction();
        },
        error: function(){
            Materialize.toast("Помилка видалення", 3000)
        }
    });
}

function sendRemoveCategory(id, successFunction){
    $.ajax({
        url: './' + id,
        type: 'DELETE',
        success: function(result) {
            Materialize.toast("Видалено", 3000);
            successFunction();
        },
        error: function(){
            Materialize.toast("Помилка видалення", 3000)
        }
    });
}