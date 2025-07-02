async function show(id) {
    var x = document.getElementById(id);

    if (x) {
        x.remove();
    } else {
        const div = document.createElement("div");
        div.className = "container";
        div.align = "center";
        div.margin = "auto";
        // div.innerHTML = `<p>This is dynamic HTML content. ID ${id} </p>`;
        if (id == "Pracownicy"){
            const prac = await(fetchAndCreateTable(id))
            div.appendChild(prac);
        }
        else if (id == "Klienci"){
            const kli = await(fetchAndCreateTable(id))
            div.appendChild(kli);
        }
        else if (id == "Producenci"){
            const prod = await(fetchAndCreateTable(id))
            div.appendChild(prod);
        }
        else if (id == "Reklamy"){
            const rekl = await(fetchAndCreateTable(id))
            div.appendChild(rekl);
        }
        else if (id == "Stacje"){
            const stac = await(fetchAndCreateTable(id))
            div.appendChild(stac);
        }
        document.body.appendChild(div);
    }
}