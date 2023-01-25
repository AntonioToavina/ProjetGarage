class Card{
    labelle;
    rect;
    x;
    y;
}

function draw(card,arrow,content) {
    var width = 500;
    var height =300;

    var stage = new Konva.Stage({
        container: content,
        width: width,
        height: height,
    });
    var layer = new Konva.Layer();


// add the shape to the layer
    for(var i=0;i<card.length;i++){
        layer.add(card[i].labelle);
        layer.add(card[i].rect);
    }
    layer.add(arrow);
// add the layer to the stage
    stage.add(layer);
}

function createCard1(data){
    const card=new Card();
    card.x=90;
    card.y=90;
    card.rect= new Konva.Rect({
        x: 40,
        y: 40,
        width: 50,
        height: 50,
        fill: 'blue',
    });

    card.labelle= new Konva.Text({
        x: 20,
        y: 5,
        text: data.ressource.nom,
        fontSize: 20,
        fontFamily: 'Calibri',
        fill: 'black',
    });
    return card;
}

function createCard2(data){
    const card=new Card();
    card.x=340;
    card.y=90;
    card.rect= new Konva.Rect({
        x: 340,
        y: 40,
        width: 50,
        height: 50,
        fill: 'blue',
    });

    card.labelle= new Konva.Text({
        x: 340,
        y: 5,
        text: data.ressource.nom,
        fontSize: 20,
        fontFamily: 'Calibri',
        fill: 'black',
    });
    return card;
}

function createCard3(data){
    const card=new Card();
    card.x=90;
    card.y=200;
    card.rect= new Konva.Rect({
        x: 40,
        y: 200,
        width: 50,
        height: 50,
        fill: 'blue',
    });

    card.labelle= new Konva.Text({
        x: 40,
        y: 260,
        text: data.ressource.nom,
        fontSize: 20,
        fontFamily: 'Calibri',
        fill: 'black',
    });
    return card;
}

function createCard4(data){
    const card=new Card();
    card.x=340;
    card.y=200;
    card.rect= new Konva.Rect({
        x: 340,
        y: 200,
        width: 50,
        height: 50,
        fill: 'blue',
    });

    card.labelle= new Konva.Text({
        x: 340,
        y: 260,
        text: data.ressource.nom,
        fontSize: 20,
        fontFamily: 'Calibri',
        fill: 'black',
    });
    return card;
}

function createCard(data){
    const card=[];
    card.push(createCard1(data[0]));
    card.push(createCard2(data[1]));
    card.push(createCard3(data[2]));
    card.push(createCard4(data[3]));
    return card;
}

function getMax1(datas){
    let value=0;
    let id=0;
    for(var i=0;i<datas.length;i++){
        if(datas[i].proportion>value){
            value=datas[i].proportion;
            id=i;
        }
    }
    return id;
}

function getMax_min1(value,datas){
    let id=0;
    let val=0;
    for(let i=0;i<datas.length;i++){
        if(value==datas[i].proportion)
            continue;
        else{
            if(datas[i].proportion>val){
                id=i;
                val=datas[i].proportion;
            }
        }
    }
    return id;
}

function getMax_min2(value,datas){
    let id=0;
    let val=0;
    for(let i=0;i<datas.length;i++){
        if(value==datas[i].durete)
            continue;
        else{
            if(datas[i].durete>val){
                id=i;
                val=datas[i].durete;
            }
        }
    }
    return id;
}

function getMax2(datas){
    let value=0;
    let id=0;
    for(var i=0;i<datas.length;i++){
        if(datas[i].durete>value){
            value=datas[i].durete;
            id=i;
        }
    }
    return id;
}

function getMax_min3(value,datas){
    let id=0;
    let val=0;
    for(let i=0;i<datas.length;i++){
        if(value==datas[i].efficacite)
            continue;
        else{
            if(datas[i].efficacite>val){
                id=i;
                val=datas[i].efficacite;
            }
        }
    }
    return id;
}

function getMax3(datas){
    let value=0;
    let id=0;
    for(var i=0;i<datas.length;i++){
        if(datas[i].efficacite>value){
            value=datas[i].efficacite;
            id=i;
        }
    }
    return id;
}

function getMax_min5(value,datas){
    let id=0;
    let val=0;
    for(let i=0;i<datas.length;i++){
        if(value==datas[i].exploitation)
            continue;
        else{
            if(datas[i].exploitation>val){
                id=i;
                val=datas[i].exploitation;
            }
        }
    }
    return id;
}

function getMax5(datas){
    let value=0;
    let id=0;
    for(let i=0;i<datas.length;i++){
        if(datas[i].exploitation>value){
            value=datas[i].exploitation;
            id=i;
        }
    }
    return id;
}
function positionArrow(data,card,idmax,idmin,c1,c2){
    var arrow =new Konva.Arrow({
        pointerLength: 30,
        points:[card[idmin].x, card[idmin].y, card[idmax].x, card[idmax].y],
        pointerWidth: 30,
        fillLinearGradientStartPoint: { x: -50, y: -50 },
        fillLinearGradientEndPoint: { x: 50, y: 50 },
        fillLinearGradientColorStops: [0, c1, 1, c2],
        strokeLinearGradientStartPoint:{ x:card[idmin].x, y:card[idmin].y},
        strokeLinearGradientEndPoint: { x:card[idmax].x, y:card[idmax].y},
        strokeLinearGradientColorStops: [0,c1,1,c2],
        strokeWidth: 4,
    });

    return arrow;
}

function createProportion(datas){
    const card=createCard(datas);
    let idmax=getMax1(datas);
    let idmin=getMax_min1(datas[idmax].proportion,datas);
    const arrow=positionArrow(datas,card,idmax,idmin,'yellow','red');
    draw(card,arrow,'graph1');
}

function createDurete(datas){
    const card=createCard(datas);
    let idmax=getMax2(datas);
    let idmin=getMax_min2(datas[idmax].durete,datas);
    const arrow=positionArrow(datas,card,idmax,idmin,'grey','black');
    draw(card,arrow,'graph2');
}

function createEfficacite(datas){
    const card=createCard(datas);
    let idmax=getMax3(datas);
    let idmin=getMax_min3(datas[idmax].efficacite,datas);
    const arrow=positionArrow(datas,card,idmax,idmin,'white','green');
    draw(card,arrow,'graph3');
}

function createExploitation(datas){
    const card=createCard(datas);
    let idmax=getMax5(datas);
    let idmin=getMax_min5(datas[idmax].exploitation,datas);
    const arrow=positionArrow(datas,card,idmax,idmin,'white','green');
    draw(card,arrow,'graph4');
}

function setData1(datas){
    createProportion(datas);
    createDurete(datas);
    createEfficacite(datas);
    createExploitation(datas);
}