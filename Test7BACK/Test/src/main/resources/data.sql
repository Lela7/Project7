INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, uloga)
              VALUES (1,'miroslav@maildrop.cc','miroslav','$2y$12$NH2KM2BJaBl.ik90Z1YqAOjoPgSd0ns/bF.7WedMxZ54OhWQNNnh6','Miroslav','Simic','ADMIN');
INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, uloga)
              VALUES (2,'tamara@maildrop.cc','tamara','$2y$12$DRhCpltZygkA7EZ2WeWIbewWBjLE0KYiUO.tHDUaJNMpsHxXEw9Ky','Tamara','Milosavljevic','KORISNIK');
INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, uloga)
             VALUES (3,'petar@maildrop.cc','petar','$2y$12$i6/mU4w0HhG8RQRXHjNCa.tG2OwGSVXb0GYUnf8MZUdeadE4voHbC','Petar','Jovic','KORISNIK');
             
             
             
INSERT INTO format (id, tip, broj_ucesnika) VALUES (1, 'GRAND SLAM', 5000);   
INSERT INTO format (id, tip, broj_ucesnika) VALUES (2, 'MASTERS 1000', 1000);    
INSERT INTO format (id, tip, broj_ucesnika) VALUES (3, 'MASTERS 500', 500);    
INSERT INTO format (id, tip, broj_ucesnika) VALUES (4, 'MASTERS 250', 250);    



INSERT INTO takmicenje (id, naziv, mesto, pocetak, zavrsetak, format_id) VALUES (1, 'Australian Open', 'Cirih', '22/03/2023', '29/03/2023', 2);
INSERT INTO takmicenje (id, naziv, mesto, pocetak, zavrsetak, format_id) VALUES (2, 'Australian Open1', 'Melburn','22/03/2023', '29/03/2023', 3);
INSERT INTO takmicenje (id, naziv, mesto, pocetak, zavrsetak, format_id) VALUES (3, 'Rome','Cikago', '22/03/2023', '29/03/2023', 1);
INSERT INTO takmicenje (id, naziv, mesto, pocetak, zavrsetak, format_id) VALUES (4, 'Cirkus Open','London', '22/03/2023', '29/03/2023', 4);


INSERT INTO prijava (id, drzava, kontakt, datum_prijave, takmicenje_id) VALUES (1, 'Australija', 'zorica@mail.drop', '22/06/2023', 1);
INSERT INTO prijava (id, drzava, kontakt, datum_prijave, takmicenje_id) VALUES (2,'Francuska', 'milica@mail.drop', '19/09/2023', 3);
INSERT INTO prijava (id, drzava, kontakt, datum_prijave, takmicenje_id) VALUES (3, 'Italija', 'radoje@mail.drop', '12/09/2022', 2);
INSERT INTO prijava (id, drzava, kontakt, datum_prijave, takmicenje_id) VALUES (4, 'Nemacka', 'zoran@mail.drop', '08/08/2022', 4);