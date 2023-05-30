var buttonB = document.getElementById('action-btnB');
var buttonC = document.getElementById('action-btnC')

var sectionServiços = document.getElementById('serviços');
var sectionContato = document.getElementById('contato');

var allSections = document.querySelectorAll('section');

function esconderSections(){
    allSections.forEach((section) => {
        section.classList.add('hide');
    })
}

// BOTÃO -> SERVIÇOS 

buttonB.addEventListener('click', function(){
    esconderSections();
    sectionServiços.classList.toggle('hide');
})

// BOTÃO -> CONTATOS

buttonC.addEventListener('click', function(){
    esconderSections();
    sectionContato.classList.toggle('hide');
})

const form = document.forms['formnome'];

Array.from(form.elements).forEach(element =>{
    console.log(element.name, element.name)
})

// ESTRUTURA JSON SEPARADA DO USER.JSON

var contato =
[
    {
        "nome":"João Victor",
        "idade":"18",
        "email":"JSander@gnail.br"
    }
]
