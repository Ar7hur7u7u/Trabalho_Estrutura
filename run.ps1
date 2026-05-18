$ErrorActionPreference = "Stop"

$javacCommand = Get-Command javac -ErrorAction SilentlyContinue
if ($javacCommand) {
    $javac = $javacCommand.Source
} else {
    $javac = Get-ChildItem "C:\Program Files\JetBrains", "$env:LOCALAPPDATA\Programs", "$env:LOCALAPPDATA" -Recurse -Filter javac.exe -ErrorAction SilentlyContinue |
        Select-Object -First 1 -ExpandProperty FullName
}

if (-not $javac) {
    Write-Host "O compilador javac nao foi encontrado."
    Write-Host "Instale um JDK ou abra o projeto no IntelliJ IDEA com um SDK configurado."
    exit 1
}

$java = Join-Path (Split-Path $javac -Parent) "java.exe"

New-Item -ItemType Directory -Force -Path "out" | Out-Null

& $javac -encoding UTF-8 -d out src/main/java/br/com/trabalho/*.java
& $java -cp out br.com.trabalho.Main
