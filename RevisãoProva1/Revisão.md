# Revisão Prova I - AED III

1. Conceitos Fundamentais sobre Arquivos
    1.1 **Definição de Arquivo**
    - Arquivo: Um conjunto de dados dispostos de forma sequencial.
      - **Arquivo lógico**: A forma como os dados são organizados e vistos pelo usuário/programa.
      - **Arquivo físico**: Como os dados são armazenados no hardware (HD, SSD, etc)

    1.2 **Tipos de Arquivos**
    - **Texto**: Contém apenas texto (Caracteres ASCII ou Unicode).
    - **Binário**: Armazena dados em formato binário, como imagens ou vídeos.
    - **Arquivos Regulares**: Contém dados de usuários.
    - **Arquivos de Sistema**: Contém informações do sistema operacional;
    -**Arquivos Especiais**: Usados para comunicação entre processos ou com dispositivos.

2. Streams e Buffer
    2.1 **Stream**
   - Stream:  Fluxo de dados entre o programam e o arquivo. A comunicação com o arquivo (leitura e escrita) é feita por meio de streams:
     - **InputStream**: Para leitura.
     - **OutputStream**: Para escrita.

    2.2 **Buffer**
    - Buffer: Utilizado para melhorar a performance de leitura e escrita de arquivos.
      - **Buffer de Leitura**: Armazena dados lidos antes de enviá-los ao programa
      - **Buffer de Escrita**: Armazena dados antes de escrevê-los no arquivo. O buffer é esvaziado quando está cheio, através do processo chamado *flush*.

3. Operações com Arquivos em Java
    3.1 **Leitura de Arquivos**
    - Para ler um arquivo, podemos usar **FileReader** e **BufferedReader**:

``` java
  FileReader fr = new FileReader("Arquivo.txt");
  BufferedReader reader = new BufferedReader(fr);

  String linha;

  while ((linha = reader.readLine()) != null) {
    System.out.println(linha);
  }

  reader.close();
```

- **BufferedReader**: otimiza a leitura com o uso de buffers.

    3.2 **Escrita de Arquivos**
  - Para escrever em um arquivo, usado **FileOutputStream** e **DataOutputStream**:

``` java
  FileOutputStream wr = new FileOutputStream("arquivo.txt")
  DataOutputStream dos = new DataOutputStream(wr);

  dos.write(56);
  dos.writeFloat(45.9f);
  dos.writeUTF("Texto de exemplo");
  dos.close();
```

  