-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 09, 2024 at 08:08 AM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `task_tracker`
--

-- --------------------------------------------------------

--
-- Table structure for table `notifications`
--

CREATE TABLE `notifications` (
  `id` int(11) NOT NULL,
  `project` varchar(255) NOT NULL,
  `task_name` varchar(255) NOT NULL,
  `description` text NOT NULL,
  `user_id` int(11) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `notifications`
--

INSERT INTO `notifications` (`id`, `project`, `task_name`, `description`, `user_id`, `created_at`) VALUES
(4, 'Project Alpha', 'Task 1', 'Complete the initial setup', 1, '2024-07-25 10:39:30'),
(5, 'Project Beta', 'Task 2', 'Design the database schema', 1, '2024-07-25 10:39:30'),
(6, 'Project Gamma', 'Task 3', 'Implement the user authentication', 4, '2024-07-25 10:39:30');

-- --------------------------------------------------------

--
-- Table structure for table `project`
--

CREATE TABLE `project` (
  `project_id` int(11) NOT NULL,
  `project_name` varchar(1024) NOT NULL,
  `project_des` varchar(1024) NOT NULL,
  `start_date` date NOT NULL,
  `due_date` date NOT NULL,
  `isStarted` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `project`
--

INSERT INTO `project` (`project_id`, `project_name`, `project_des`, `start_date`, `due_date`, `isStarted`) VALUES
(26, 'Mobile Fitness App', 'Created a mobile fitness application for Android and iOS using React Native. The app tracks workouts, monitors progress, and provides personalized exercise recommendations. Implemented features include user registration, social media integration, push notifications, and real-time analytics.', '2024-08-08', '2024-08-15', 1),
(27, ' Sales Data Analysis Dashboard', ' Designed and developed an interactive sales data dashboard using Python, Pandas, and Dash. The dashboard visualizes key sales metrics, trends, and KPIs through various charts and graphs. Implemented filters and drill-down capabilities to allow users to explore data at different granularities.', '2024-08-28', '2024-08-29', 0),
(28, 'Chatbot for Customer Support', ' Developed an AI-powered chatbot using Python and the Rasa framework to handle customer support queries. Integrated the chatbot with a web interface and connected it to a backend CRM system for seamless issue tracking and resolution. The bot can understand natural language queries and provide context-aware responses.', '2024-08-10', '2024-08-11', 0),
(37, 'Task Manager', 'A simple task management tool where users can create, update, delete, and organize tasks. It includes features like due dates, priority levels, and categorization into projects. The project is ideal for practicing CRUD operations and user authentication.', '2024-08-03', '2024-08-29', 0),
(38, 'Weather Dashboard', ': A dashboard that provides real-time weather information for different cities around the world. Users can search for a city to get current conditions, a 7-day forecast, and weather alerts. This project integrates APIs and showcases responsive design techniques.', '2024-08-17', '2024-08-30', 0),
(39, ' E-commerce Store', 'A fully functional online store with product listings, a shopping cart, and a checkout process. Users can browse products, view details, add items to the cart, and place orders. The backend handles inventory management, order processing, and payment integration.', '2024-08-24', '2024-08-23', 0),
(40, 'Personal Budget Tracker', 'A web or mobile application that helps users track their income, expenses, and savings. Users can categorize expenses, set budgets for different categories, and visualize their spending patterns with charts and graphs.', '2024-08-15', '2024-08-29', 0),
(41, 'Chat Application', ' A real-time chat application that supports one-on-one and group conversations. Users can send messages, share files, and see when others are typing. The project demonstrates the use of WebSockets for real-time communication and user authentication.', '2024-08-21', '2024-08-31', 0);

-- --------------------------------------------------------

--
-- Table structure for table `startproject`
--

CREATE TABLE `startproject` (
  `startId` int(32) NOT NULL,
  `projectId` int(11) NOT NULL,
  `userId` int(11) NOT NULL,
  `status` varchar(100) NOT NULL DEFAULT 'started'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `startproject`
--

INSERT INTO `startproject` (`startId`, `projectId`, `userId`, `status`) VALUES
(78, 26, 27, 'FINISH');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `email` varchar(100) NOT NULL,
  `user_role` varchar(50) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `first_name`, `last_name`, `email`, `user_role`, `password`) VALUES
(1, 'yeran', 'lakvidu', 'cst21077@std.uwu.ac.lk', 'admin', '81dc9bdb52d04dc20036dbd8313ed055'),
(4, 'admin', 'admin', 'admin@gmail.com', 'admin', '81dc9bdb52d04dc20036dbd8313ed055'),
(21, 'shehan', 'chathuranga', 'shehanchathu250@gmail.com', 'aaaaa', '81dc9bdb52d04dc20036dbd8313ed055'),
(25, 'pethum', 'nissanka', 'abd@gmail.com', 'devopopere', '81dc9bdb52d04dc20036dbd8313ed055'),
(26, 'fev', 'verv', 'vvvv@gmail.com', 'gre', '81dc9bdb52d04dc20036dbd8313ed055'),
(27, 'perera', 'wimalarathne', 'anula123@gmail.com', 'developer', '81dc9bdb52d04dc20036dbd8313ed055');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `notifications`
--
ALTER TABLE `notifications`
  ADD PRIMARY KEY (`id`),
  ADD KEY `user_id` (`user_id`);

--
-- Indexes for table `project`
--
ALTER TABLE `project`
  ADD PRIMARY KEY (`project_id`);

--
-- Indexes for table `startproject`
--
ALTER TABLE `startproject`
  ADD PRIMARY KEY (`startId`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email` (`email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `notifications`
--
ALTER TABLE `notifications`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `project`
--
ALTER TABLE `project`
  MODIFY `project_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=43;

--
-- AUTO_INCREMENT for table `startproject`
--
ALTER TABLE `startproject`
  MODIFY `startId` int(32) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=79;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `notifications`
--
ALTER TABLE `notifications`
  ADD CONSTRAINT `notifications_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
