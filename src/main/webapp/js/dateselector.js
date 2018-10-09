function creatDate()
{
    for(var i = 2018; i >= 2015; i--)
    {
        var option = document.createElement('option');
        option.setAttribute('value',i);
        option.innerHTML = i;
        sel1.appendChild(option);
    }

    for(var i = 1; i <=12; i++){
        var option1 = document.createElement('option');
        option1.setAttribute('value',i);
        option1.innerHTML = i;
        sel2.appendChild(option1);
    }
    for(var i = 1; i <=31; i++){
        var option2 = document.createElement('option');
        option2.setAttribute('value',i);
        option2.innerHTML = i;
        sel3.appendChild(option2);
    }
}
creatDate();
var days;

sel1.onclick = function()
{
    sel2.options[0].selected = true;

    sel3.options[0].selected = true;
}
sel2.onclick = function()
    {
        sel3.options[0].selected = true;

        if(sel2.value == 2)
        {
            if((sel1.value % 4 === 0 && sel1.value % 100 !== 0) || sel1.value % 400 === 0)
            {
                days = 29;
            }
            else
            {
                days = 28;
            }
        }else if(sel2.value == 4 || sel2.value == 6 ||sel2.value == 9 ||sel2.value == 11){
            days = 30;
        }else{
            days = 31;
        }

        if(days == 28){
            sel3.remove(31);
            sel3.remove(30);
            sel3.remove(29);
        }
        if(days == 29){
            sel3.remove(31);
            sel3.remove(30);
            if(!sel3.options[29]){
                sel3.add(new Option('29','29'),null)
            }
        }
        if(days == 30){
            sel3.remove(31);
            if(!sel3.options[29]){
                sel3.add(new Option('29','29'),null)
            }
            if(!sel3.options[30]){
                sel3.add(new Option('30','30'),null)
            }
        }

        if(days == 31){

            if(!sel3.options[29])
            {
                sel3.add(new Option('29','29'),null)
            }

            if(!sel3.options[30])
            {
                sel3.add(new Option('30','30'),null)
            }

            if(!sel3.options[31])
            {
                sel3.add(new Option('31','31'),null)
            }
        }
    }
