function fetchAndCreateTable(id) {
    return fetch(`/api/${id}`)
        .then(response => response.json())
        .then(list => createTable(list, id))
}

function createTable(list, id) {
    // Create a table element
    if (id == 'Pracownicy') {
        var table = document.createElement("table");
        table.border = "1";
        table.cellPadding = "10";
        table.id = id;
        // table.style.width = "80%";
        table.style.backgroundColor = "#fff";
        table.style.color = "#000";
        table.style.borderCollapse = "collapse";
        table.style.marginTop = "20px";
        table.align = "center";
        // Create the table header
        var thead = document.createElement("thead");
        var headerRow = document.createElement("tr");
        var headers = ["ID", "Imie", "Drugie Imie", "Nazwisko", "Data urodzin", "Zarobki", "PESEL", "Data zatrudnienia", "Stanowisko", "Edycja", "Usuwanie"];
        headers.forEach(headerText => {
            var header = document.createElement("th");
            header.textContent = headerText;
            header.style.padding = "10px";
            header.style.textAlign = "left";
            header.style.borderBottom = "1px solid #ddd";
            header.style.backgroundColor = "#343a40";
            header.style.color = "#fff";
            headerRow.appendChild(header);
        });
        thead.appendChild(headerRow);
        table.appendChild(thead);

        // Create and fill the body of the table
        var tbody = document.createElement("tbody");
        list.forEach(pracownik => {
            var row = document.createElement("tr");
            row.appendChild(createCell(pracownik.id_pracownika));
            row.appendChild(createCell(pracownik.imie));
            row.appendChild(createCell(pracownik.drugie_imie));
            row.appendChild(createCell(pracownik.nazwisko));
            row.appendChild(createCell(pracownik.data_urodzin));
            row.appendChild(createCell(pracownik.zarobki));
            row.appendChild(createCell(pracownik.pesel));
            row.appendChild(createCell(pracownik.data_zatrudnienia));
            row.appendChild(createCell(pracownik.stanowisko));
            row.appendChild(createThWithHref(`/edit/pracownicy/${pracownik.id_pracownika}`, "Edytuj"))
            row.appendChild(createThWithHref(`/delete/pracownicy/${pracownik.id_pracownika}`, "Usuń"))
            tbody.appendChild(row);
        });
        table.appendChild(tbody);
    }
    else if (id == 'Klienci') {
        var table = document.createElement("table");
        table.border = "1";
        table.cellPadding = "10";
        table.id = id;
        // table.style.width = "80%";
        table.style.backgroundColor = "#fff";
        table.style.color = "#000";
        table.style.borderCollapse = "collapse";
        table.style.marginTop = "20px";
        table.align = "center";
        // Create the table header
        var thead = document.createElement("thead");
        var headerRow = document.createElement("tr");
        var headers = ["ID", "Nazwa", "Wycena umowy", "Liczba reklam", "Data zawarcia", "Data zakończenia", "Nr telefonu", "NIP", "Adres e-mail", "Edycja", "Usuwanie"];
        headers.forEach(headerText => {
            var header = document.createElement("th");
            header.textContent = headerText;
            header.style.padding = "10px";
            header.style.textAlign = "left";
            header.style.borderBottom = "1px solid #ddd";
            header.style.backgroundColor = "#343a40";
            header.style.color = "#fff";
            headerRow.appendChild(header);
        });
        thead.appendChild(headerRow);
        table.appendChild(thead);

        // Create and fill the body of the table
        var tbody = document.createElement("tbody");
        list.forEach(klient => {
            var row = document.createElement("tr");
            row.appendChild(createCell(klient.id_klienta));
            row.appendChild(createCell(klient.nazwa));
            row.appendChild(createCell(klient.wycena_umowy));
            row.appendChild(createCell(klient.liczba_reklam));
            row.appendChild(createCell(klient.data_zawarcia));
            row.appendChild(createCell(klient.data_zakonczenia));
            row.appendChild(createCell(klient.nr_telefonu));
            row.appendChild(createCell(klient.nip));
            row.appendChild(createCell(klient.adres_email));
            row.appendChild(createThWithHref(`/edit/klienci/${klient.id_klienta}`, "Edytuj"))
            row.appendChild(createThWithHref(`/delete/klienci/${klient.id_klienta}`, "Usuń"))
            tbody.appendChild(row);
        });
        table.appendChild(tbody);
    }
    else if (id == 'Producenci') {
        var table = document.createElement("table");
        table.border = "1";
        table.cellPadding = "10";
        table.id = id;
        // table.style.width = "80%";
        table.style.backgroundColor = "#fff";
        table.style.color = "#000";
        table.style.borderCollapse = "collapse";
        table.style.marginTop = "20px";
        table.align = "center";
        // Create the table header
        var thead = document.createElement("thead");
        var headerRow = document.createElement("tr");
        var headers = ["ID", "Nazwa", "Data założenia", "NIP", "KRS", "Edycja", "Usuwanie"];
        headers.forEach(headerText => {
            var header = document.createElement("th");
            header.textContent = headerText;
            header.style.padding = "10px";
            header.style.textAlign = "left";
            header.style.borderBottom = "1px solid #ddd";
            header.style.backgroundColor = "#343a40";
            header.style.color = "#fff";
            headerRow.appendChild(header);
        });
        thead.appendChild(headerRow);
        table.appendChild(thead);

        // Create and fill the body of the table
        var tbody = document.createElement("tbody");
        list.forEach(producent => {
            var row = document.createElement("tr");
            row.appendChild(createCell(producent.id_producenta));
            row.appendChild(createCell(producent.nazwa));
            row.appendChild(createCell(producent.data_zalozenia));
            row.appendChild(createCell(producent.nip));
            row.appendChild(createCell(producent.krs));
            row.appendChild(createThWithHref(`/edit/producenci/${producent.id_producenta}`, "Edytuj"))
            row.appendChild(createThWithHref(`/delete/producenci/${producent.id_producenta}`, "Usuń"))
            tbody.appendChild(row);
        });
        table.appendChild(tbody);
    }
    else if (id == 'Reklamy') {
        var table = document.createElement("table");
        table.border = "1";
        table.cellPadding = "10";
        table.id = id;
        // table.style.width = "80%";
        table.style.backgroundColor = "#fff";
        table.style.color = "#000";
        table.style.borderCollapse = "collapse";
        table.style.marginTop = "20px";
        table.align = "center";
        // Create the table header
        var thead = document.createElement("thead");
        var headerRow = document.createElement("tr");
        var headers = ["ID", "Czas trwania", "Kanal dystrybucji", "Grupa docelowa", "Edycja", "Usuwanie"];
        headers.forEach(headerText => {
            var header = document.createElement("th");
            header.textContent = headerText;
            header.style.padding = "10px";
            header.style.textAlign = "left";
            header.style.borderBottom = "1px solid #ddd";
            header.style.backgroundColor = "#343a40";
            header.style.color = "#fff";
            headerRow.appendChild(header);
        });
        thead.appendChild(headerRow);
        table.appendChild(thead);

        // Create and fill the body of the table
        var tbody = document.createElement("tbody");
        list.forEach(reklama => {
            var row = document.createElement("tr");
            row.appendChild(createCell(reklama.id_reklamy));
            row.appendChild(createCell(reklama.czas_trwania));
            row.appendChild(createCell(reklama.kanal_dystrybucji));
            row.appendChild(createCell(reklama.grupa_docelowa));
            row.appendChild(createThWithHref(`/edit/reklamy/${reklama.id_reklamy}`, "Edytuj"))
            row.appendChild(createThWithHref(`/delete/reklamy/${reklama.id_reklamy}`, "Usuń"))
            tbody.appendChild(row);
        });
        table.appendChild(tbody);
    }
    else if (id == 'Stacje') {
        var table = document.createElement("table");
        table.border = "1";
        table.cellPadding = "10";
        table.id = id;
        // table.style.width = "80%";
        table.style.backgroundColor = "#fff";
        table.style.color = "#000";
        table.style.borderCollapse = "collapse";
        table.style.marginTop = "20px";
        table.align = "center";
        // Create the table header
        var thead = document.createElement("thead");
        var headerRow = document.createElement("tr");
        var headers = ["ID", "Ilość pracowników", "Rodzaj stacji", "Częstotliwość", "Edycja", "Usuwanie"];
        headers.forEach(headerText => {
            var header = document.createElement("th");
            header.textContent = headerText;
            header.style.padding = "10px";
            header.style.textAlign = "left";
            header.style.borderBottom = "1px solid #ddd";
            header.style.backgroundColor = "#343a40";
            header.style.color = "#fff";
            headerRow.appendChild(header);
        });
        thead.appendChild(headerRow);
        table.appendChild(thead);

        // Create and fill the body of the table
        var tbody = document.createElement("tbody");
        list.forEach(stacja => {
            var row = document.createElement("tr");
            row.appendChild(createCell(stacja.id_stacji));
            row.appendChild(createCell(stacja.ilosc_pracownikow));
            row.appendChild(createCell(stacja.rodzaj_stacji));
            row.appendChild(createCell(stacja.czestotliwosc));
            row.appendChild(createThWithHref(`/edit/stacje/${stacja.id_stacji}`, "Edytuj"));
            row.appendChild(createThWithHref(`/delete/stacje/${stacja.id_stacji}`, "Usuń"));
            tbody.appendChild(row);
        });
        table.appendChild(tbody);
    }

    return table;
}

function createCell(value) {
    var cell = document.createElement("td");
    // alert(`create cell + ${value}`)
    cell.textContent = value;
    return cell;
}

function createThWithHref(hrefValue, linkText) {
    var th = document.createElement("th");
    var link = document.createElement("a");
    link.href = hrefValue;
    link.textContent = linkText;
    th.appendChild(link);
    return th;
}

