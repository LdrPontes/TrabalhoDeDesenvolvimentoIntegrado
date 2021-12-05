import 'dart:convert';
import 'dart:io';
import 'dart:typed_data';

import 'package:csv/csv.dart';
import 'package:file_picker/file_picker.dart';
import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({Key? key}) : super(key: key);

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Client',
      theme: ThemeData(
        primarySwatch: Colors.amber,
      ),
      home: const MyHomePage(
          title: 'CSM30 - Desenvolvimento Integrado de Sistemas'),
    );
  }
}

class MyHomePage extends StatefulWidget {
  const MyHomePage({Key? key, required this.title}) : super(key: key);

  final String title;

  @override
  State<MyHomePage> createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text(widget.title),
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: <Widget>[
            const Text(
              'Carregar sinal ultrassom:',
            ),
            const SizedBox(
              height: 32,
            ),
            TextButton(
              onPressed: _onPressed,
              style: ButtonStyle(
                backgroundColor: MaterialStateProperty.all(
                  Colors.black,
                ),
              ),
              child: const Text(
                'UPLOAD',
              ),
            ),
            const Text(
              '',
            ),
          ],
        ),
      ),
    );
  }

  void _onPressed() async {
    var picked = await FilePicker.platform.pickFiles(
      type: FileType.custom,
      allowedExtensions: ['csv'],
    );

    if (picked != null) {
      final input = picked.files.first.bytes!;

      final csv =
          const CsvToListConverter().convert(String.fromCharCodes(input));

    }
  }
}
