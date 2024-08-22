import dados
from pygame import mixer

def MenuLogin():
    print("|| Menu Login\n|| 1. Utilizador\n|| 2. Admin\n|| 0. Sair")
    opt=input("|| Opção:")
    if opt=="1":
        MenuInicial(False)
    elif opt=="2":
        if input("|| Introduza a senha:")=="admin":
            MenuInicial(True)
        else:
            print("|| Password errada")
    elif opt=="0":
        print("|| Terminado com sucesso")
    else:
        print("|| O valor introduzido é inválido")

def MenuInicial(admin):
    if admin==True:
        while True:
            print("--------------------")
            print("|| Menu Admin\n|| 1. Pesquisar\n|| 2. Adicionar\n|| 3. Apagar\n|| 4. Calcular Direitos Editoriais\n|| 0. Sair")
            opt=input("|| Opção:")
            if opt=="1":
                MenuPesquisar()
            elif opt=="2":
                MenuAdicionar()
            elif opt=="3":
                MenuApagar()
            elif opt=="4":
                artista = input("|| Introduza o nome do Artista para calcular os Direitos editoriais:")
                print("Cálculo das vendas é de: ", dados.calculo(artista), "€")
            elif opt=="0":
                print("|| Terminado com sucesso")
                break
            else:
                print("|| O valor introduzido é inválido")
                continue
    else:
        while True:
            print("--------------------")
            print("|| Menu Inicial\n|| 1. Pesquisar\n|| 0. Sair")
            opt=input("|| Opção:")
            if opt=="1":
                MenuPesquisar()
            elif opt=="0":
                print("|| Terminado com sucesso")
                break
            else:
                print("|| O valor introduzido é inválido")
                continue
#Acessivel a admin e utilizador
#Quando for criada a função de leitura e escrita do ficheiro csv retirar Direitos editorais á lista do utilizador
def MenuPesquisar():
    while True:
        print("--------------------")
        print("|| Menu De Pesquisa\n|| 1. Artista\n|| 2. Álbum\n|| 3. Música\n|| 4. Reprodutor\n|| 5. Listar Todos os Álbuns\n|| 0. Voltar")
        opt=input("|| Opção:")
        if opt=="1":
            print("|| Pesquisa por Artistas")
            artista = input("|| Introduza o Nome Do Artista:")
            dados.pArtista(artista)
        elif opt=="2":
            print("|| Pesquisa por Álbuns")
            album = input("|| Introduza o Nome Do Álbum:")
            dados.pAlbum(album)
        elif opt=="3":
            print("|| Pesquisa por Músicas")            
            musica = input("|| Introduza o Nome Da Música:")
            dados.pMusica(musica)
        elif opt=="4":
            dados.playListMusica()            
            musica = input("|| Introduza o Nome Da Música para ouvir a Demo:")
            dados.playMusica(musica)
        elif opt=="5":
            dados.listAlbuns()
        elif opt=="0":
            break
        else:
            print("|| O valor introduzido é inválido")
            continue
#Só acessivel a admin
def MenuAdicionar():
        while True:
            print("--------------------")
            print("|| Menu Adicionar\n|| 1. Adicionar Artistas\n|| 2. Adicionar Álbuns\n|| 3. Adicionar Músicas\n|| 4. Listar Todos os Artistas\n|| 5. Listar Todos os Álbuns\n|| 0. Voltar")
            opt=input("|| Opção:")
            if opt=="1":
                print("|| Adicionar Artistas")
                nome = input("|| Introduza o Nome do Artista:")
                nacionalidade = input("|| Introduza a Nacionalidade:")
                royalty = input("|| Direitos editoriais:")
                dados.gArtista(nome,nacionalidade,royalty)
            elif opt=="2":
                print("|| Adicionar Álbuns")
                artista = input("|| Introduza o Artista:")
                nome = input("|| Introduza o Nome do Álbum:")
                genero = input("|| Introduza o Género Musical:")
                data = input("|| Introduza a Data de Lançamento:")
                vendas = input("|| Introduza as Unidades Vendidas:")
                preco = input("|| Introduza o Preço:")
                dados.gAlbum(artista,nome,genero,data,vendas,preco)
            elif opt=="3":
                print("|| Adicionar Músicas")
                artista = input("|| Introduza o Artista:")
                album = input("|| Introduza o Álbum:")
                adicionar = "sim"
                while adicionar == "sim":
                    musica = input("|| Introduza o nome da música:")
                    ficheiro = input("|| Tem demo?: (sim/não):")
                    adicionar = input("|| Adicionar outra Música ao Álbum? (sim/não):")
                    dados.gMusica(artista,album,musica,ficheiro)
            elif opt=="4":
                dados.listAll()
            elif opt=="5":
                dados.listAlbuns()
            elif opt=="0":
                break
            else:
                print("|| O valor introduzido é inválido")
                continue
            
def MenuApagar():
        while True:
            print("--------------------")
            print("|| Menu Apagar\n|| 1. Artista\n|| 2. Álbum\n|| 3. Música\n|| 4. Listar Todos os Artistas\n|| 5. Listar Todos os Álbuns\n|| 0. Voltar")
            opt=input("|| Opção:")
            if opt=="1":
                print("|| Apagar por Artista, Vai eliminar também os Álbuns e as Músicas")
                nome = input("|| Introduza o Nome:")
                dados.aArtista(nome)
            elif opt=="2":
                print("|| Apagar por Álbum, Vai eliminar também as Músicas")
                nome = input("|| Introduza o Nome do Álbum:")
                dados.aAlbum(nome)
            elif opt=="3":
                print("|| Apagar Música")
                nome = input("|| Introduza o Nome da Música:")
                dados.aMusica(nome)
            elif opt=="4":
                dados.listAll()
            elif opt=="5":
                dados.listAlbuns() 
            elif opt=="0":
                break
            else:
                print("|| O valor introduzido é inválido")
                continue

def MenuPlay():
        while True:
            print("--------------------")
            print("|| Menu De Reprodução\n|| 1. Pausar\n|| 2. Resumir\n|| 0. Voltar")
            opt=input("|| Opção:")
            if opt=="1":
                print("|| Reprodução da música pausada")
                mixer.music.pause()
            elif opt=="2":
                print("|| Reprodução da música resumida")
                mixer.music.unpause()
            elif opt=="0":
                print("|| Reprodução da música parada com sucesso")
                mixer.quit()
                break
            else:
                print("|| O valor introduzido é inválido")
                continue
