-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 18, 2025 at 10:13 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `library_system`
--

-- --------------------------------------------------------

--
-- Table structure for table `books_inv`
--

CREATE TABLE `books_inv` (
  `book_id` int(11) NOT NULL,
  `bk_id` varchar(20) NOT NULL,
  `book_title` varchar(255) NOT NULL,
  `book_author` varchar(50) NOT NULL,
  `book_category` varchar(30) NOT NULL,
  `book_copies` int(11) DEFAULT 1,
  `book_status` varchar(10) NOT NULL,
  `book_cost` decimal(18,4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `books_inv`
--

INSERT INTO `books_inv` (`book_id`, `bk_id`, `book_title`, `book_author`, `book_category`, `book_copies`, `book_status`, `book_cost`) VALUES
(1, 'BK-001', 'To Kill a Mockingbird', 'Harper Lee', 'Fiction', 5, 'Available', 4.0000),
(2, 'BK-002', '1984', 'George Orwell', 'Dystopian', 3, 'Available', 3.5000),
(3, 'BK-003', 'The Great Gatsby', 'F. Scott Fitzgerald', 'Classic', 4, 'Borrowed', 5.0000),
(4, 'BK-004', 'Harry Potter and the Sorcerer\'s Stone', 'J.K. Rowling', 'Fantasy', 6, 'Available', 4.5000),
(5, 'BK-005', 'The Hobbit', 'J.R.R. Tolkien', 'Fantasy', 2, 'Borrowed', 3.0000),
(6, 'BK-006', 'The Catcher in the Rye', 'J.D. Salinger', 'Classic', 3, 'Available', 4.0000),
(7, 'BK-007', 'Atomic Habits', 'James Clear', 'Self-Help', 5, 'Available', 5.0000),
(8, 'BK-008', 'Rich Dad Poor Dad', 'Robert Kiyosaki', 'Finance', 4, 'Available', 4.5000),
(9, 'BK-009', 'The Alchemist', 'Paulo Coelho', 'Fiction', 6, 'Available', 3.8000),
(10, 'BK-010', 'Thinking, Fast and Slow', 'Daniel Kahneman', 'Psychology', 3, 'Borrowed', 5.0000),
(11, 'BK-011', 'The Lean Startup', 'Eric Ries', 'Business', 4, 'Available', 4.2000),
(12, 'BK-012', 'Meditations', 'Marcus Aurelius', 'Philosophy', 2, 'Available', 3.5000),
(13, 'BK-013', 'Sapiens', 'Yuval Noah Harari', 'History', 5, 'Borrowed', 4.8000),
(14, 'BK-014', 'Pride and Prejudice', 'Jane Austen', 'Classic', 3, 'Available', 4.0000),
(15, 'BK-015', 'The Subtle Art of Not Giving a F*ck', 'Mark Manson', 'Self-Help', 4, 'Available', 4.5000);

-- --------------------------------------------------------

--
-- Table structure for table `book_return_table`
--

CREATE TABLE `book_return_table` (
  `return_id` int(11) NOT NULL,
  `std_id` int(11) NOT NULL,
  `book_id` int(11) NOT NULL,
  `copies_borrowed` int(11) DEFAULT 1,
  `release_date` date NOT NULL COMMENT 'Date the book was borrowed',
  `due_date` date NOT NULL,
  `return_date` date DEFAULT NULL,
  `status` varchar(20) DEFAULT 'Returned'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `borrowers_record`
--

CREATE TABLE `borrowers_record` (
  `borrower_id` int(11) NOT NULL,
  `book_id` int(11) NOT NULL,
  `std_id` int(11) NOT NULL,
  `staff_id` int(11) NOT NULL,
  `num_of_copies` int(11) DEFAULT 1,
  `release_date` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `due_date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `borrowers_record`
--

INSERT INTO `borrowers_record` (`borrower_id`, `book_id`, `std_id`, `staff_id`, `num_of_copies`, `release_date`, `due_date`) VALUES
(1, 7, 1, 1, 1, '2025-12-01 07:30:00', '2025-12-08');

-- --------------------------------------------------------

--
-- Table structure for table `student_table`
--

CREATE TABLE `student_table` (
  `std_id` int(11) NOT NULL,
  `std_school_id_number` varchar(11) NOT NULL,
  `std_fname` varchar(30) NOT NULL,
  `std_lname` varchar(20) NOT NULL,
  `std_course` varchar(20) DEFAULT NULL,
  `std_address` varchar(50) NOT NULL,
  `std_contact_num` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `student_table`
--

INSERT INTO `student_table` (`std_id`, `std_school_id_number`, `std_fname`, `std_lname`, `std_course`, `std_address`, `std_contact_num`) VALUES
(1, '2023-0001', 'Adrian Jed', 'Flores Gregorio', 'DIT', 'adrian.gregorio@example.com', '0917-123-4567'),
(2, '2024-0002', 'Ashton', 'Neri', 'DIT', 'ashton.neri@example.com', '0918-987-6543'),
(3, '2022-0003', 'Carlos', 'Aragon', 'DIT', 'carlos.aragon@example.com', '0922-444-5555'),
(4, '2023-0004', 'Juliet', 'Modina', 'DIT', 'juliet.modina@example.com', '0915-111-2222'),
(5, '2021-0005', 'Zeus Justin', 'Carmona', 'DIT', 'zeus.carmona@example.com', '0906-888-9999'),
(6, '2024-0006', 'Sophia Beatrice', 'Luna', 'DIT', 'sophia.luna@example.com', '0919-333-7777'),
(7, '2022-0007', 'Marcus Vinicius', 'Reyes', 'DIT', 'marcus.reyes@example.com', '0927-555-0000'),
(8, '2024-0008', 'Elena Rose', 'Santos', 'DIT', 'elena.santos@example.com', '0933-222-1111'),
(9, '2023-0009', 'Dominic Xavier', 'Cruz', 'DIT', 'dominic.cruz@example.com', '0945-666-3333'),
(10, '2021-0010', 'Clara Isabel', 'Tiongco', 'DIT', 'clara.tiongco@example.com', '0916-777-8888');

-- --------------------------------------------------------

--
-- Table structure for table `user_table`
--

CREATE TABLE `user_table` (
  `staff_id` int(11) NOT NULL,
  `stf_id` varchar(20) NOT NULL,
  `staff_fname` varchar(30) NOT NULL,
  `staff_lname` varchar(20) NOT NULL,
  `staff_contact_num` varchar(15) DEFAULT NULL,
  `staff_email` varchar(100) NOT NULL,
  `staff_type` varchar(20) DEFAULT NULL,
  `staff_username` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `staff_password` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user_table`
--

INSERT INTO `user_table` (`staff_id`, `stf_id`, `staff_fname`, `staff_lname`, `staff_contact_num`, `staff_email`, `staff_type`, `staff_username`, `staff_password`) VALUES
(1, 'STF-001', 'Alice', 'Johnson', '555-1234', 'alice.johnson@example.com', 'Librarian', 'alicej', 'password123'),
(2, 'STF-002', 'Brian', 'Smith', '555-2345', 'brian.smith@example.com', 'Librarian', 'brians', 'password123'),
(3, 'STF-003', 'Catherine', 'Lee', '555-3456', 'catherine.lee@example.com', 'Librarian', 'cathlee', 'password123'),
(4, 'STF-004', 'David', 'Brown', '555-4567', 'david.brown@example.com', 'Librarian', 'davidb', 'password123'),
(5, 'STF-005', 'Emma', 'Davis', '555-5678', 'emma.davis@example.com', 'Librarian', 'emmad', 'password123'),
(6, 'STF-006', 'Frank', 'Miller', '555-6789', 'frank.miller@example.com', 'Librarian', 'frankm', 'password123'),
(7, 'STF-007', 'Grace', 'Wilson', '555-7890', 'grace.wilson@example.com', 'Librarian', 'gracew', 'password123');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `books_inv`
--
ALTER TABLE `books_inv`
  ADD PRIMARY KEY (`book_id`);

--
-- Indexes for table `book_return_table`
--
ALTER TABLE `book_return_table`
  ADD PRIMARY KEY (`return_id`),
  ADD KEY `std_id` (`std_id`),
  ADD KEY `book_id` (`book_id`);

--
-- Indexes for table `borrowers_record`
--
ALTER TABLE `borrowers_record`
  ADD PRIMARY KEY (`borrower_id`),
  ADD KEY `book_id` (`book_id`),
  ADD KEY `std_id` (`std_id`),
  ADD KEY `staff_id` (`staff_id`);

--
-- Indexes for table `student_table`
--
ALTER TABLE `student_table`
  ADD PRIMARY KEY (`std_id`);

--
-- Indexes for table `user_table`
--
ALTER TABLE `user_table`
  ADD PRIMARY KEY (`staff_id`),
  ADD UNIQUE KEY `staff_email` (`staff_email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `books_inv`
--
ALTER TABLE `books_inv`
  MODIFY `book_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT for table `book_return_table`
--
ALTER TABLE `book_return_table`
  MODIFY `return_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `borrowers_record`
--
ALTER TABLE `borrowers_record`
  MODIFY `borrower_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `student_table`
--
ALTER TABLE `student_table`
  MODIFY `std_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `user_table`
--
ALTER TABLE `user_table`
  MODIFY `staff_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `book_return_table`
--
ALTER TABLE `book_return_table`
  ADD CONSTRAINT `book_return_table_ibfk_1` FOREIGN KEY (`std_id`) REFERENCES `student_table` (`std_id`),
  ADD CONSTRAINT `book_return_table_ibfk_2` FOREIGN KEY (`book_id`) REFERENCES `books_inv` (`book_id`);

--
-- Constraints for table `borrowers_record`
--
ALTER TABLE `borrowers_record`
  ADD CONSTRAINT `borrowers_record_ibfk_1` FOREIGN KEY (`book_id`) REFERENCES `books_inv` (`book_id`),
  ADD CONSTRAINT `borrowers_record_ibfk_2` FOREIGN KEY (`std_id`) REFERENCES `student_table` (`std_id`),
  ADD CONSTRAINT `borrowers_record_ibfk_3` FOREIGN KEY (`staff_id`) REFERENCES `user_table` (`staff_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
